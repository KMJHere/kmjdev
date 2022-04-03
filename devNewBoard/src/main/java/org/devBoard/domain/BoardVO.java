package org.devBoard.domain;

import java.util.Date;

public class BoardVO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	//private int viewcnt;		

	public Integer getbno() {
		return bno;
	}

	public void setbno(Integer bno) {
		this.bno = bno;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public String getwriter() {
		return writer;
	}

	public void setwriter(String writer) {
		this.writer = writer;
	}

	public Date getregdate() {
		return regdate;
	}

	public void setregdate(Date regdate) {
		this.regdate = regdate;
	}
}
