package ds.practice.second.service;


import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Paging {
	private int currentPage = 1;	private int rowPage   = 10;
	private int pageBlock = 10;		
	private int start;				private int end;
	private int startPage;			private int endPage;
	private int total;				private int totalPage;
	
	private int row = 10;			private int offset;

	public Paging(int total, String currentPage1) {
		this.total = total;
		if (currentPage1 == null) {
			this.currentPage = 1;
		} else {
			this.currentPage = Integer.parseInt(currentPage1);			
		}
		start = (currentPage - 1) * rowPage + 1;  // 시작시 1
		end   = start + rowPage - 1;              // 시작시 10 
		totalPage = (int) Math.ceil((double)total / rowPage);  // 시작시 2
		startPage = currentPage - (currentPage - 1) % pageBlock; // 시작시 1
		endPage = startPage + pageBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		offset = (currentPage-1)*10;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowPage() {
		return rowPage;
	}

	public void setRowPage(int rowPage) {
		this.rowPage = rowPage;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

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

	
	
	
}
