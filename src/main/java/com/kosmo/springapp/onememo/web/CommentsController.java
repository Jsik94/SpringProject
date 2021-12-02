package com.kosmo.springapp.onememo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosmo.springapp.comments.service.LineCommentService;


@SessionAttributes({"id"})//시큐 적용시 삭제 예정
@RestController
@RequestMapping("/onememo/comments/")
public class CommentsController {

	//서비스 주입 
	@Autowired
	private LineCommentService service;
	@Autowired
	private ObjectMapper mapper;
	
	//Object Mapper API 주입
	//@PostMapping(value="/onememo/comments/List.do",produces = "text/plain; charset=UTF-8")
	@PostMapping(value =  "List.do", produces = "application/json; charset=UTF-8")
	public List<Map> list(@ModelAttribute("id") String id,
			@RequestParam Map map) throws JsonProcessingException {
		
		System.out.println("동작합니다! : "+ map.get("no"));

		List<Map> lists = service.selectList(map);
		for(Map atom : lists) {
			atom.put("LPOSTDATE", atom.get("LPOSTDATE").toString().substring(0,10));
		}
		
		//JSONize
//		String comments = mapper.writeValueAsString(lists);
//		System.out.println(lists.get(0).get("LPOSTDATE"));
//		return comments;
		return lists;
	}
	
	//코멘트 입력처리 ]
	@PostMapping(value="Write.do",produces= "text/plain; charset=UTF-8")
	public String write(@ModelAttribute("id") String id,@RequestParam Map map) {

		System.out.println(this.getClass().getName() + "| WRITE | START");
		map.put("id",id);//시큐리티 적용시 삭제 예정 
		//서비스 호출
		String commentInfo = service.insert(map);
		//데이터 반환

		System.out.println(this.getClass().getName() + "| WRITE | END");		
		return commentInfo ;
		
	}
	
	
	//수정한 값의 키값을 반환 할것임
	@PostMapping(value="Edit.do",produces = "text/plain; charset=UTF-8")
	public String Edit(@ModelAttribute("id") String id,@RequestParam Map map) {

		System.out.println(this.getClass().getName() + "| EDIT | START");
		System.out.println("lno : " + map.get("lno"));
		System.out.println("linecomment : " + map.get("linecomment"));
		service.update(map);

		System.out.println(this.getClass().getName() + "| EDIT | END");
		
		return map.get("lno").toString();
	}
	
	
	@PostMapping(value="Delete.do",produces = "text/plain; charset=UTF-8")
	public String delete(@ModelAttribute("id") String id,@RequestParam Map map) {

		System.out.println(this.getClass().getName() + "| DELETE | START");
		System.out.println("lno : " + map.get("lno"));
		int affected = service.delete(map);

		System.out.println(this.getClass().getName() + "| DELETE | END");
		
		return map.get("lno").toString();
	}
	
}
