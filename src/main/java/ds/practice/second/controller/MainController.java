package ds.practice.second.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ds.practice.second.dto.AppMemDTO;
import ds.practice.second.dto.ApplicantDTO;
import ds.practice.second.dto.EventDTO;
import ds.practice.second.dto.GradeVO;
import ds.practice.second.dto.MemberDTO;
import ds.practice.second.dto.WinAppMemDTO;
import ds.practice.second.dto.WinnerDTO;
import ds.practice.second.service.MainService;
import ds.practice.second.service.Paging;

@Controller
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MainService mainService;

	@RequestMapping(value = "main.do")
	public String main() {

		return "main";
	}

	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public String joinForm() {

		return "join";
	}

	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public ModelAndView join(MemberDTO memberDTO) {
		ModelAndView mv = new ModelAndView("join");
		logger.debug(memberDTO.getMemberId());
		logger.debug(memberDTO.getMemberName());
		logger.debug(memberDTO.getMemberPw());
		logger.debug(memberDTO.getMemberPhone());
		int result = mainService.insertMember(memberDTO);
		logger.debug("result :" + result);
		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginForm() {

		return "login";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberDTO memberDTO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		List<MemberDTO> loginMember = mainService.getMember(memberDTO);

		if (loginMember.isEmpty()) {
			mv.setViewName("login");
		} else if (loginMember.get(0).getMemberId().equals("admin")) {
			session.setAttribute("memberId", loginMember.get(0).getMemberId());
			mv.setViewName("redirect:eventApplicant.do");
		} else {
			logger.debug("loginMember = " + loginMember.get(0).getMemberId());
			session.setAttribute("memberId", loginMember.get(0).getMemberId());
			mv.setViewName("redirect:event.do");
		}
		return mv;
	}
	
	//event응모하기 Page
	@RequestMapping(value = "event.do", method = RequestMethod.GET)
	public ModelAndView eventForm(MemberDTO loginMember, HttpServletRequest request) {
		String member = (String) request.getSession().getAttribute("memberId");
		EventDTO eDTO = new EventDTO();
		List<EventDTO> eList = mainService.getEventList(eDTO);
		ModelAndView mv = new ModelAndView("eventPage");
		mv.addObject("member", member);
		mv.addObject("eList", eList);
		return mv;
	}
	
	//이벤트 응모하기
	@RequestMapping(value = "eventApply.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> eventApply(HttpServletRequest request, ApplicantDTO aDTO) {
		// ajax return value
		Map<String, String> result = new HashMap<String, String>();
		// member PK
		int idMember = 0;

		// 세션에 아이디값 가져와서 member정보를 가져온다.
		String memberId = (String) request.getSession().getAttribute("memberId");
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMemberId(memberId);
		List<MemberDTO> member = mainService.getMember(mDTO);
		idMember = member.get(0).getIdmember();

		// 검색 조건 세팅 [ id(pk), eventCode ]
		aDTO.setIdMember(idMember);

		// 검색 조건에 맞는 값이 있는지 확인
		int count = mainService.getApplyStatus(aDTO);

		if (count > 0) {
			result.put("result", "duplication");
		} else {
			int insert = mainService.insertApplicant(aDTO);
			if (insert > 0) {
				result.put("result", "success");
			}
		}
		return result;
	}
	
	//로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();

		return "login";
	}
	
	//응모자 List Page
	@RequestMapping(value = "eventApplicant.do")
	public ModelAndView adminForm(ApplicantDTO aDTO) {
		ModelAndView mv = new ModelAndView("eventApplicant");
		//추첨 안한 이벤트 리스트 가져오기
		EventDTO eventDTO = new EventDTO();
		eventDTO.setWinnerYn("N");
		List<EventDTO> eventList = mainService.getEventList(eventDTO);
		//리스트중에 첫번째 이벤트 코드
		String eventCode = eventList.get(0).getEventCode();
		
		//첫 페이지 접근 시도 ( eventCode초기화 )
		if(aDTO.getEventCode()==null) {
			aDTO.setEventCode(eventCode);
		}else { // 선택한 이벤트코드로 값 설정
			eventCode = aDTO.getEventCode();
		}
		
		List<AppMemDTO> aplicantList = mainService.getApplicantList(aDTO);
		
		mv.addObject("applicantList", aplicantList);
		mv.addObject("eventList", eventList);
		mv.addObject("eventCode", eventCode);
		
		return mv;
	}
	
	//당첨자 추첨하기
	@RequestMapping(value = "draw.do")
	public ModelAndView draw(ApplicantDTO aDTO, GradeVO gradeVO, RedirectAttributes rttr) {
		ModelAndView mv = new ModelAndView("redirect:winnerList.do");
		// 현재 이벤트 Code
		String eventCode = aDTO.getEventCode();
		// 당첨자 추첨 여부
		String winnerYn = mainService.getWinnerYn(eventCode);
		// 해당 이벤트 응모자 리스트
		List<AppMemDTO> applicantList = mainService.getApplicantList(aDTO);
		// 추첨 진행할 인원 수
		int totalCnt = applicantList.size();
		// 등수별 총 당첨자 수
		int totalGradeCnt = gradeVO.getTotal();
		logger.debug(gradeVO.toString());
		
		if(winnerYn.equals("Y")) {

			rttr.addAttribute("eventCode", eventCode);
			rttr.addAttribute("winnerYn", winnerYn);

			return mv;
		}

		// 추첨하기
		Random rand = new Random();
		int[] winner = new int[totalGradeCnt]; // 당첨자 저장 배열
		int index = 0;

		while (true) {
			int check = 0; // 중복확인 위한 check변수
			int rand_num = rand.nextInt(totalCnt) + 1; // lucky_number draw

			// 인원 다 뽑았으면 while문 종료
			if (index >= winner.length) {
				break;
			}

			for (int i = 0; i < totalGradeCnt; i++) {
				if (winner[i] == rand_num) {
					check++;
				}
			}
			if (check <= 0) {
				winner[index] = rand_num;
				index++;
			}
		}
		for (int i = 0; i < winner.length; i++) {
			System.out.println("winner[" + i + "] =>" + winner[i]);
		}
		
		//당첨자 DB에 INSERT하기
		for (int i = 0; i < winner.length; i++) {
			WinnerDTO wDTO = new WinnerDTO();
			if(i==0) {
				wDTO.setEventCode(eventCode);
				wDTO.setLuckyNumber(winner[i]);
				wDTO.setGoods(1);
				mainService.insertWinner(wDTO);
			}else if(i<=gradeVO.getSecond()) {
				wDTO.setEventCode(eventCode);
				wDTO.setLuckyNumber(winner[i]);
				wDTO.setGoods(2);
				mainService.insertWinner(wDTO);
			}else if(i<=(gradeVO.getSecond()+gradeVO.getThird())) {
				wDTO.setEventCode(eventCode);
				wDTO.setLuckyNumber(winner[i]);
				wDTO.setGoods(3);
				mainService.insertWinner(wDTO);
			}else if(i<=(gradeVO.getSecond()+gradeVO.getThird()+gradeVO.getFourth())) {
				wDTO.setEventCode(eventCode);
				wDTO.setLuckyNumber(winner[i]);
				wDTO.setGoods(4);
				mainService.insertWinner(wDTO);
			}
		}

		
		// 이벤트 당첨자 추첨시 event close
		int result = mainService.modiEventYn(eventCode);
		
		rttr.addAttribute("eventCode", eventCode);
		rttr.addAttribute("winnerYn", winnerYn);

		return mv;
	}
	//당첨자 리스트
	@RequestMapping(value = "winnerList.do", method = RequestMethod.GET)
	public ModelAndView winnerList(@RequestParam Map<String,Object> requestParam) {
		ModelAndView mv = new ModelAndView("winnerList");
		String eventCode = (String)requestParam.get("eventCode");
		String firstEventCode = null;
		EventDTO eventDTO = new EventDTO();
		eventDTO.setWinnerYn("Y");
		
		List<EventDTO> eventList = mainService.getEventList(eventDTO);
		firstEventCode = eventList.get(0).getEventCode();
		
		if(eventCode==null) {
			eventCode = firstEventCode;
		}
		
		// 당첨자 정보 가져오기
		List<WinAppMemDTO> wamList = mainService.getWinnerInfo(eventCode);
		
		mv.addObject("eventList", eventList );
		mv.addObject("winnerList", wamList );
		mv.addObject("eventCode", eventCode );
		
		
		return mv;
	}
	
	//당첨자 추첨 Form
	@RequestMapping(value = "winnerCount.do", method = RequestMethod.GET)
	public ModelAndView winnerCount(EventDTO eventDTO) {
		ModelAndView mv = new ModelAndView("winnerCount");
		ApplicantDTO aDTO = new ApplicantDTO();
		aDTO.setEventCode(eventDTO.getEventCode());
		
		int eventCount = mainService.getApplyStatus(aDTO);
		List<EventDTO> eventList = mainService.getEventList(eventDTO);
		
		mv.addObject("eventCount", eventCount );
		mv.addObject("event" , eventList.get(0));
		
		return mv;
	}

	@RequestMapping(value = "eventRegister.do", method = RequestMethod.GET)
	public ModelAndView eventRegisterForm(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("eventRegister");
		
		return mv;
	}
	
	@RequestMapping(value = "eventRegister.do", method = RequestMethod.POST)
	public ModelAndView eventRegister(HttpServletRequest request, EventDTO eventDTO) {
		ModelAndView mv = new ModelAndView("redirect:eventList.do");
		DateFormat dateFormat = new SimpleDateFormat ("yyyy.MM.dd");

		int result = mainService.insertEvent(eventDTO);
				
		return mv;
	}
	
	@RequestMapping(value = "eventList.do", method = RequestMethod.GET)
	public ModelAndView eventList(HttpServletRequest request, String currentPage) {
		ModelAndView mv = new ModelAndView("eventList");
		EventDTO eventDTO = new EventDTO();
		int totalCount = mainService.getEventCount(eventDTO);
		Paging pg = new Paging(totalCount,currentPage);
		
		eventDTO.setRow(pg.getRow());
		eventDTO.setOffset(pg.getOffset());
		
		List<EventDTO> eventList = mainService.getEventList(eventDTO);
		
		mv.addObject("eventList", eventList);
		mv.addObject("pg", pg);
		return mv;
	}
}
