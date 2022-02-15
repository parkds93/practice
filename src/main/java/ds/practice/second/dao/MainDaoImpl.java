package ds.practice.second.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ds.practice.second.dto.AppMemDTO;
import ds.practice.second.dto.ApplicantDTO;
import ds.practice.second.dto.EventDTO;
import ds.practice.second.dto.MemberDTO;
import ds.practice.second.dto.WinAppMemDTO;
import ds.practice.second.dto.WinnerDTO;

@Repository
public class MainDaoImpl implements MainDao {
	@Autowired
	SqlSessionTemplate session;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public int insertMember(MemberDTO memberDTO) {
		int result = session.insert("insertMember",memberDTO);
		return result;
	}
	
	@Override
	public List<MemberDTO> getMember(MemberDTO memberDTO) {
		List<MemberDTO> loginMember = session.selectList("selectMember",memberDTO);

		return loginMember;
	}
	
	@Override
	public int insertApplicant(ApplicantDTO aDTO) {
		int result = session.insert("insertApplicant",aDTO);
		return result;
	}
	
	@Override
	public int getApplyStatus(ApplicantDTO aDTO) {
		int count  = session.selectOne("selectApplicantCount",aDTO);
		return count;
	}
	
	@Override
	public List<AppMemDTO> getApplicantList(ApplicantDTO aDTO) {
		List<AppMemDTO> aList = session.selectList("selectApplicantList",aDTO);
		return aList;
	}
	
	@Override
	public int insertWinner(WinnerDTO wDTO) {
		int result = session.insert("insertWinner",wDTO);
		return result;
	}
	
	@Override
	public List<EventDTO> getEventList(EventDTO eventDTO) {
		List<EventDTO> eventList = session.selectList("selectEventList",eventDTO);
		return eventList;
	}
	
	@Override
	public int getEventCount(EventDTO eventDTO) {
		int eventCount = session.selectOne("selectEventCount",eventDTO);
		return eventCount;
	}
	
	@Override
	public List<WinAppMemDTO> getWinnerInfo(String eventCode) {
		List<WinAppMemDTO> wamDTO = session.selectList("selectWinInfo",eventCode);
		return wamDTO;
	}
	
	@Override
	public int modiEventYn(String eventCode) {
		int result = session.update("UpdateEventYn",eventCode);
		return result;
	}
	
	@Override
	public String getWinnerYn(String eventCode) {
		String winnerYn = session.selectOne("getWinnerYn", eventCode);
		return winnerYn;
	}
	
	@Override
	public int insertEvent(EventDTO eventDTO) {
		int result = session.insert("insertEvent",eventDTO);
		return result;
	}
}
