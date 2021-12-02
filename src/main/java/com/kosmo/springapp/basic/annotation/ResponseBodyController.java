package com.kosmo.springapp.basic.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

	//방법1] 
	/*
	@RequestMapping("/Annotation/ResponseBody.do")
	public void execute(HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<fieldset>");
		out.println("<legend>반환타입 void Response 사용해서 출력</legend>");
		out.println("</fieldset>");
	
	}
	*/
	
	//방법2] 서블릿 API 사용하지 않고 @responseBody를 이용
	//브라우저에 바로 출력하겠다.라는 의미임. 반환되는 문자열이 브라우저에 쓰인다는 의미임 
	//단 인코딩 처리를 위해 mapping에서 처리해줘야할게 잇음
	//mapping에 속성이 여러개일땐, 명령은  value 값으로 주고 , produces 값에 마임타입 주면됨,단 여러개일경우 중괄호로 사용하묜된다.
	@RequestMapping(value ="/Annotation/ResponseBody.do",produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String execute() {
		
		return "<h2>웹 브라우저로 직접 출력합니다.</h2>";
	}
}
