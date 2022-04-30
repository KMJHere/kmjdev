package org.devBoard.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	// 화면에 보일 페이징 수
	private int displayPageNum = 10;
	
	private Criteria cri;
	
	public Integer gettotalCount() {
		return totalCount;
	} 
	
	public Integer getstartPage() {
		return startPage;
	}
	
	public void setstartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getendPage() {
		return endPage;
	}
	
	public void setendPage(Integer endPage) {
		this.endPage = endPage;
	}
	
	public boolean getprev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean getnext() {
		return next;
	}
	
	public void setnext(boolean next) {
		this.next = next;
	}
	
	
	public Criteria getCri() {
		return cri;
	}
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
															.queryParam("page", page)
															.queryParam("perPageNum", cri.getPerPageNum())
															.build();
		return uriComponents.toUriString();
	}
}
