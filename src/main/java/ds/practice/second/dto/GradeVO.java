package ds.practice.second.dto;

public class GradeVO {
	private int first;
	private int second;
	private int third;
	private int fourth;
	
	private int total;
	
	

	public int getFirst() {
		return first;
	}


	public void setFirst(int first) {
		this.first = first;
	}


	public int getTotal() {
		return first+second+third+fourth;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getSecond() {
		return second;
	}


	public void setSecond(int second) {
		this.second = second;
	}


	public int getThird() {
		return third;
	}


	public void setThird(int third) {
		this.third = third;
	}


	public int getFourth() {
		return fourth;
	}


	public void setFourth(int fourth) {
		this.fourth = fourth;
	}


	
	@Override
	public String toString() {
		return "총 당첨자 수 : "+ (first+second+third+fourth)
				+"\n1등 :"+first
				+"\n2등 :"+second
				+"\n3등 :"+third
				+"\n4등 :"+fourth;
	}
	
}
