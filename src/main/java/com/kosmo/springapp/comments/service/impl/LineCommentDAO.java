package com.kosmo.springapp.comments.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LineCommentDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	public List<Map> selectList(Map map) {
		// TODO Auto-generated method stub
		System.out.println("맵 no : " + map.get("no"));
		return template.selectList("commentListsUsingCollectionAjax",map);
	}

	public int insert(Map map) {
		// TODO Auto-generated method stub
		
		template.insert("commentInsert",map);
		//새롭게 입력된 댓글의 키(lno) 반환 
		
		//To String 전환
		return Integer.parseInt(map.get("lno").toString());
	}

	public String findNameById(String id) {
		// TODO Auto-generated method stub
		
		return template.selectOne("memoFindNameById",id);
	}

	public int update(Map map) {
		// TODO Auto-generated method stub
		
		
		return template.update("commentUpdate", map);
	}

	public int delete(Map map) {
		// TODO Auto-generated method stub
		return template.delete("commentDelete", map);
	}

	public int deleteByNo(Map map) {
		// TODO Auto-generated method stub
		
		return template.delete("commentDeleteByNo", map);
	}


	
	
}
