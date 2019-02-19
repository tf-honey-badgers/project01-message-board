package org.badgers.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageDTO_hyun {
	
	private Criteria cri; //
	
	private int staretPage; // 일빠따 
	
	private int endPage; // 마지막 

	private int totalCount; // 총합계 
	

	private boolean prev;
	
	private boolean next;
	
	private int viewPagingNum = 10; // 페이징 갯수 
	
	public void setTotalCount(int count) {
		this.totalCount = count;
		
		calc();
	}
	
	private void calc() {
		endPage = (int) (Math.ceil(cri.getPage() / (double) viewPagingNum) * viewPagingNum);
		staretPage = endPage - viewPagingNum + 1;
		int tempLastPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if(endPage > tempLastPage) { endPage = tempLastPage; }
		
		prev = staretPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeUri(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", cri.getPerPageNum()).build();
		
		return uriComponents.toUriString();
	}
}