package com.kosmo.springapp.basic.returntype;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
public class ReturnTypeController {

	@RequestMapping("/ReturnType/ModelAndView.do")
	// @RequestParam은 Map으로도가능 모두가 key value로 바뀜
	public ModelAndView modelAndView(@RequestParam Map map, Model model) {

////		map.get("returnType");
//
//		// 1] model에 데이터 삽입 REQSCOPE
//		model.addAttribute("message","Way1]Param is : " + map.get("returnType"));
//		model.addAllAttributes(map);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("chap04_returntype/ReturnType");
//		return new ModelAndView("chap04_returntype/ReturnType");
//
//		// 2] model도 안쓴다
////		ModelAndView mav = new ModelAndView();
////		mav.setViewName("chap04_returntype/ReturnType");
////		model.addAttribute("message","Way2] Param is : " + map.get("returnType"));
////		mav.addAllObjects(map);
////		return mav;
////		
//		// 3] internalResourceView 사용
////		ModelAndView mav = new ModelAndView();
////		mav.setView(new InternalResourceView("WEB-INF/views/chap04_returntype/ReturnType.jsp"));
////		mav.setViewName("forward:/WEB-INF/views/chap04_returntype/ReturnType.jsp");
////		model.addAttribute("message", "Way2] Param is : " + map.get("returnType"));
////		mav.addAllObjects(map);
//
////		System.out.println("check View" + mav.getView());
////		return mav;

		//방법1]
				//데이타 저장-Model에 데이타 저장
				//model.addAllAttributes(map);
				//model.addAttribute("message",String.format("[파라미터:%s]",map.get("returnType")));
				//뷰정보 저장-ModelAndView에 뷰정보만 저장
				//return new ModelAndView("returntype04/ReturnType");
				//방법2]-매개변수에 Model 필요 없음
				//데이타 저장-ModelAndView에 데이타 저장
				ModelAndView mav = new ModelAndView();
				model.addAttribute("message",String.format("[파라미터:%s]",map.get("returnType")));
				mav.addAllObjects(map);
				//뷰정보 저장-ModelAndView에 뷰정보 저장
				//mav.setViewName("returntype04/ReturnType");
				mav.setView(new InternalResourceView("/WEB-INF/views/chap04_returntype/ReturnType.jsp"));
				
				return mav;	
		
	}

	/*
	 *  뷰로 반환하냐 String or Model And View 
	 * 
	 *  데이터만 반환하냐 
	 *  @ResponeBody
	 *  void String or Object
	 *  
	 */
	
	@RequestMapping("/ReturnType/String.do")
	public String string(@RequestParam String returnType, Map map) {

		map.put("message", "Param is : " + returnType);
		map.put("returnType", returnType);

		return "chap04_returntype/ReturnType";
	}

	@RequestMapping("/ReturnType/Void.do")
	public String noreturn(@RequestParam String returnType, HttpServletResponse resp) throws IOException {

		/*
		 * -Ajax나 RestApi 사용시 구현 -DispatcherServlet에게 모델 및 뷰정보 전달 안함 ViewResolver를 거치지
		 * 않음 - 웹브라우저에 바로 출력시 즉, http 응답바디에 데이터 출력시 사용
		 */
		// 응답헤더에 사용
		resp.setContentType("text/html; charset=UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<fieldset>");
		out.println("<legend> 반환타입 :" + returnType);
		out.println("<legend>");
		out.println("<h2>웹 브라우저로 직접 출력하기 </h2>");
		out.println("</fieldset>");
		// 스트림 닫기

		out.close();
		return "chap04_returntype/ReturnType";
	}

}
