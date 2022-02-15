package ds.practice.second.dto;

import java.util.Date;

public class ApplicantDTO {
	int num;
	int idMember;
	String eventCode;
	int luckyNumber;
	Date date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLuckyNumber() {
		return luckyNumber;
	}
	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	
	
}
