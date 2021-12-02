package com.kosmo.springapp.comments.service;

import java.util.List;
import java.util.Map;

public interface LineCommentService {

	//이번엔 맵으로 할꺼임
	
	List<Map> selectList(Map map);
	String insert(Map map);
	int update(Map map);
	int delete(Map map);
	
}
