package ds.practice.second.service;

import java.util.List;

import ds.practice.second.dto.AppMemDTO;
import ds.practice.second.dto.ApplicantDTO;
import ds.practice.second.dto.EventDTO;
import ds.practice.second.dto.MemberDTO;
import ds.practice.second.dto.WinAppMemDTO;
import ds.practice.second.dto.WinnerDTO;

public interface MainService {

	int insertMember(MemberDTO memberDTO);

	List<MemberDTO> getMember(MemberDTO memberDTO);

	int insertApplicant(ApplicantDTO aDTO);

	int getApplyStatus(ApplicantDTO aDTO);

	List<AppMemDTO> getApplicantList(ApplicantDTO aDTO);

	int insertWinner(WinnerDTO wDTO);

	List<EventDTO> getEventList(EventDTO eventDTO);

	int getEventCount(EventDTO eventDTO);

	List<WinAppMemDTO> getWinnerInfo(String eventCode);

	int modiEventYn(String eventCode);

	String getWinnerYn(String eventCode);

	int insertEvent(EventDTO eventDTO);

}
