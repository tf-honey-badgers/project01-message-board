package org.badgers.domain;

public class Criteria_Joon implements Criteria{
	
	private int page;
	private int perPageNum;
	
	public Criteria_Joon() {
		this.page = 1;
		this.perPageNum = 20;
	}

	public int getPageStart() {
		return (this.page-1) * this.perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		if(page <= 0) {
			this.page = 1;
		}else {
			this.page = page;
		}
		
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 20;
		}else {
			this.perPageNum = page;
		}
	}

	@Override
	public String toString() {
		return "Criteria_Joon [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
}
