package com.kosmo.springapp.onememo.service;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//페이징 관련 정보와 레코드
@Getter
@Setter
@Builder
public class ListPagingData<T extends MyDTO> {
	
	private List<T> lists;
	private int totalRecordCount;
	private int pageSize;
	private int blockPage;
	private int nowPage;
	private String pagingString;
}
