package ds.practice.second.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDTO {
	private String eventCode;
	private String eventName;
	private String eventDetail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventEndDate;
	private String WinnerYn;
	
	int row;
	int offset;
	

	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public String getWinnerYn() {
		return WinnerYn;
	}
	public void setWinnerYn(String winnerYn) {
		WinnerYn = winnerYn;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDetail() {
		return eventDetail;
	}
	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}
	public Date getEventDate() {
		return eventDate;
	}

	
	
}
