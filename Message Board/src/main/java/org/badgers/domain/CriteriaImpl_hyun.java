package org.badgers.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CriteriaImpl_hyun implements Criteria {
//	// page -> 변수 -> 현재 페이지	
//	// perPageNum -> 변수 -> 페이지당 몇 개 보여줄지 지정
//	// startPage -> 변수가 아니라 limit에서 1번째 값 지정하는데 계산한다!
//	
//	public void setPage(int page);
//	
//	public void setPerPageNum(int perPageNum);
//	
//	public int getPage();
//	
//	// method for MyBatis SQL Mapper -> SQL문의 limit에서 1번째 값
//	public int getPageStart();
//	
//	// method for MyBatis SQL Mapper -> SQL문의 limit에서 2번째 값
//	public int getPerPageNum();

	// page -> 변수 -> 현재 페이지
	private int page;
	// perPageNum -> 변수 -> 페이지당 몇 개 보여줄지 지정
	private int perPageNum;
	// startPage -> 변수가 아니라 limit에서 1번째 값 지정하는데 계산한다!

	// 화면당 10개씩 보여줄거다
	public CriteriaImpl_hyun() {
		this.page = 1;
		this.perPageNum = 10;
	}

	// 페이지가 0 이 하이면 1p (시작 ) 그외는 현재 p
	public void setPage(int page) {
		if (page < 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum < 0 || perPageNum > 100) {
			this.perPageNum = 10;
		} else {
			this.perPageNum = perPageNum;
		}
	}

	// method for MyBatis SQL Mapper -> SQL문의 limit에서 1번째 값
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}

}
