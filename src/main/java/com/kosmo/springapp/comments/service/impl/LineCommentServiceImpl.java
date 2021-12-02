package com.kosmo.springapp.comments.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.springapp.comments.service.LineCommentService;

@Service("commentService")
public class LineCommentServiceImpl implements LineCommentService {

	@Autowired
	private LineCommentDAO dao; 
	
	@Override
	public List<Map> selectList(Map map) {
		// TODO Auto-generated method stub
		return dao.selectList(map);
	}

	@Override
	public String insert(Map map) {
		// TODO Auto-generated method stub
		
		System.out.println(this.getClass().getName() + "| INSERT | START");

		System.out.println(this.getClass().getName() + "| INSERT | FIRSTDAO");
		int lno = dao.insert(map);

		System.out.println(this.getClass().getName() + "| INSERT | SECOND DAO");
		String name = dao.findNameById(map.get("id").toString());

		System.out.println(this.getClass().getName() + "| INSERT | END");
		return String.format("%s:%s",lno,name );
	}

	@Override
	public int update(Map map) {
		// TODO Auto-generated method stub
		
		return dao.update(map);
	}

	@Override
	public int delete(Map map) {
		// TODO Auto-generated method stub
		
		return dao.delete(map);
	}

}
