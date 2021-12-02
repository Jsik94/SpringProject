package com.kosmo.springapp.onememo.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LineCommentDTO {
	private String lno;
	private String lineComment;
	private java.sql.Date lpostDate;
	private String id;
	private String no;
	private String name;
	@Override
	public String toString() {
		return "LineCommentDTO [lno=" + lno + ", lineComment=" + lineComment + ", lpostDate=" + lpostDate + ", id=" + id
				+ ", no=" + no + ", name=" + name + "]";
	}
	
}
