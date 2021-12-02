package com.kosmo.springapp.basic.dynamicsql;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class DynamicSqlDAO {

	
	@Autowired
	private SqlSessionTemplate template;

	public List if1(Map map) {
		// TODO Auto-generated method stub
		
		
		return template.selectList("findOneMemoWithTitleLike",map);
	}

	public List if2(Map map) {
		// TODO Auto-generated method stub
		return template.selectList("findOneMemoLike",map);
	}

	public List choose(Map map) {
		// TODO Auto-generated method stub
		return template.selectList("findOneMemoLikeChoose",map);
	}

	public List where(Map map) {
		// TODO Auto-generated method stub
		return template.selectList("findOneMemoLikeWhere",map);
	}

	public List trim1(Map map) {
		// TODO Auto-generated method stub
		return template.selectList("findOneMemoLikeTrim",map);
	}

	public int trim2(Map map) {
		// TODO Auto-generated method stub
		return  template.update("updateOnememoLikeTrim",map);
	}

	public int set(Map map) {
		// TODO Auto-generated method stub
		return template.update("updateOnememoSet",map);
	}

	public List foreach(Map map) {
		// TODO Auto-generated method stub
		
		System.out.println("SQL 오류인가 ?");
		return template.selectList("findOneMemoForeach",map);
	}

	public int foreachExam(int[] email) {
		// TODO Auto-generated method stub
		return template.delete("deleteEmail",email);
	}


}
