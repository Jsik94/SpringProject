package com.kosmo.springapp.onememo.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder// 빌더패턴 어노테이션
//@NoArgsConstructor // 기본생성자
//@AllArgsConstructor // 인자생성자 만드는놈 
//@Data
public class OneMemoDTO implements MyDTO{
	private String no;
	private String title;
	private String content;
	private java.sql.Date postDate;
	private String id;
	private String name;
	
	//각 글에 따른 댓글 총수 출력 저장용 데이터
	private String commentCount;
	
	//no에 따른 모든 한줄 댓글 목록 저장용
	//Resultmap 태그의 collection 태그 적용용 
	List<LineCommentDTO> comments;
	
	
	
}
