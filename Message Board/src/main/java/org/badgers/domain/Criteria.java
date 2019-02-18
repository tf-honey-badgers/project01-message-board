package org.badgers.domain;

public interface Criteria {
	// page -> 변수 -> 현재 페이지	
	// perPageNum -> 변수 -> 페이지당 몇 개 보여줄지 지정
	// startPage -> 변수가 아니라 limit에서 1번째 값 지정하는데 계산한다!
	
	public void setPage(int page);
	
	public void setPerPageNum(int perPageNum);
	
	public int getPage();
	
	// method for MyBatis SQL Mapper -> SQL문의 limit에서 1번째 값
	public int getPageStart();
	
	// method for MyBatis SQL Mapper -> SQL문의 limit에서 2번째 값
	public int getPerPageNum();
}