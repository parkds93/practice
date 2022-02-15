package ds.practice.second.dto;

import java.util.Date;

public class WinAppMemDTO {
	private int idMember;
	private Date date;
	private String eventCode;
	private int luckNumber;
	private String memberId;
	private String memberName;
	private String memberPw;
	private String memberPhone;
	private String goods;
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
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public int getLuckNumber() {
		return luckNumber;
	}
	public void setLuckNumber(int luckNumber) {
		this.luckNumber = luckNumber;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
