package com.kosmo.springapp.onememo.service;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface OneMemoService {

	
	//로그인용]
	boolean isLogin(Map map);
	
	//목록용]
	ListPagingData<OneMemoDTO> selectList(Map map,HttpServletRequest req, int nowPage);
	
	
	//전체 레코드수
	int getTotalRecord(Map map);
	
	//상세보기용
	OneMemoDTO selectOne(Map map);
	
	//입력/수정/삭제용] //트랜잭션처리용 
	int insert(Map map);
	
	int delete(Map map);
	
	int update(Map map);
	
	//아이디로 이름 찾기
	String findNameById(String id);
	
}
