package ds.practice.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ds.practice.second.dao.MainDao;
import ds.practice.second.dto.AppMemDTO;
import ds.practice.second.dto.ApplicantDTO;
import ds.practice.second.dto.EventDTO;
import ds.practice.second.dto.MemberDTO;
import ds.practice.second.dto.WinAppMemDTO;
import ds.practice.second.dto.WinnerDTO;

@Service
public class MainServiceImpl implements MainService {
	@Autowired
	MainDao mainDao;

	@Override
	public int insertMember(MemberDTO memberDTO) {
		int result = mainDao.insertMember(memberDTO);
		return result;
	}
	
	@Override
	public List<MemberDTO> getMember(MemberDTO memberDTO) {
		
		List<MemberDTO> loginMember = mainDao.getMember(memberDTO);
		return loginMember;
	}
	
	//응모자 추가
	@Override
	public int insertApplicant(ApplicantDTO aDTO) {
		int result = mainDao.insertApplicant(aDTO);
		
		return result;
	}
	
	//응모여부 판단 Count
	@Override
	public int getApplyStatus(ApplicantDTO aDTO) {
		int count = mainDao.getApplyStatus(aDTO);
		return count;
	}
	
	@Override
	public List<AppMemDTO> getApplicantList(ApplicantDTO aDTO) {
		List<AppMemDTO> aList = mainDao.getApplicantList(aDTO);
		return aList;
	}
	
	@Override
	public int insertWinner(WinnerDTO wDTO) {
		int result = mainDao.insertWinner(wDTO);
		return result;
	}
	
	@Override
	public List<EventDTO> getEventList(EventDTO eventDTO) {
		List<EventDTO> eventList = mainDao.getEventList(eventDTO);
		return eventList;
	}
	
	@Override
	public int getEventCount(EventDTO eventDTO) {
		int eventCount = mainDao.getEventCount(eventDTO);
		return eventCount;
	}
	
	@Override
	public List<WinAppMemDTO> getWinnerInfo(String eventCode) {
		List<WinAppMemDTO> wamDTO = mainDao.getWinnerInfo(eventCode);
		return wamDTO;
	}
	
	@Override
	public int modiEventYn(String eventCode) {
		int result = mainDao.modiEventYn(eventCode);
		return result;
	}
	
	@Override
	public String getWinnerYn(String eventCode) {
		String winnerYn = mainDao.getWinnerYn(eventCode);
		return winnerYn;
	}
	
	@Override
	public int insertEvent(EventDTO eventDTO) {
		int result = mainDao.insertEvent(eventDTO);
		return result;
	}
}
