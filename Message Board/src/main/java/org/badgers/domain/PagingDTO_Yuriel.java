package org.badgers.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PagingDTO_Yuriel {
	private Criteria cri;
	private int totalCount;
	private int firstPage;
	private int lastPage;
	private boolean prev;
	private boolean next;
	private int displayPagingNum = 10; // 페이징 시 화면 아래에 보여질 페이지 개수를 10개로 설정
	
	public void setTotalCount(int count) {
		this.totalCount = count;
		
		calc();
	}
	
	private void calc() {
		lastPage = (int) (Math.ceil(cri.getPage() / (double) displayPagingNum) * displayPagingNum);
		firstPage = lastPage - displayPagingNum + 1;
		int tempLastPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if(lastPage > tempLastPage) { lastPage = tempLastPage; }
		
		prev = firstPage == 1 ? false : true;
		next = lastPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
	public String makeUri(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page).queryParam("perPageNum", cri.getPerPageNum()).build();
		
		return uriComponents.toUriString();
	}
}
