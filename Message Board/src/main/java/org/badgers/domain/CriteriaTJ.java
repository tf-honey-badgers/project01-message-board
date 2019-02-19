package org.badgers.domain;

import lombok.ToString;

@ToString
public class CriteriaTJ implements Criteria {
	// page -> 변수 -> 현재 페이지	
	// perPageNum -> 변수 -> 페이지당 몇 개 보여줄지 지정
	// startPage -> 변수가 아니라 limit에서 1번째 값 지정하는데 계산한다!
	
	private int page; // 현재페이지
	
	private int perPageNum; // 페이지당 몇 개 보여줄 건지
	
	
	public CriteriaTJ() {}
	
	public CriteriaTJ(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page=-1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 ) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return this.page;
	}
	
	// method for MyBatis SQL Mapper -> SQL문의 limit에서 2번째 값
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	// method for MyBatis SQL Mapper -> SQL문의 limit에서 1번째 값
	public int getPageStart() {
		return (this.page -1) * this.perPageNum;
	}
}