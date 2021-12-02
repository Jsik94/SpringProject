package com.kosmo.springapp.basic.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kosmo.springapp.onememo.service.ListPagingData;
import com.kosmo.springapp.onememo.service.OneMemoDTO;
import com.kosmo.springapp.onememo.service.OneMemoService;

/*
 * 	사전준비:POM.XML에 jackson-databind라이브러리 의존성 추가
 *
	[Jackson]
	Java 객체(Map혹은 DTO)를 JSON으로 변환하거나
	JSON을 Java 객체(Map혹은 DTO)로 변환하는 라이브러리
	List계열 컬렉션 즉 List<Map> 혹은 List<DTO>는
	자바스크립트로 변환시 JSON배열로 변환된다
	예] [ {key1:value2,key2:value2,},{},{},{}...]
	
	Spring 3.0 이후로부터, Jacskon과 관련된 API를 제공
	Jackson라이브러리를 사용하면 자동화 처리 가능
	
	Jackson라이브러리 POM.XML에 설정시
	MessageConverter API인 MappingJacksonHttpMessageConverter API가
	작동하여 컨트롤러가 리턴하는 객체를 후킹하여 ObjectMapper API로 JSON
	형태의 문자열로 자동으로 변환하여 반환한다.	
	1.자바객체를 JSON으로 변환시
	writeValue(File객체,DTO혹은 MAP) :객체를 JSON파일(.json)로 변환	
	writeValueAsString(DTO혹은 MAP):객체를 JSON형식의 문자열로 변환
	writerWithDefaultPrettyPrinter().writeValueAsString(DTO혹은 MAP)
	2.JSON을 자바객체로 변환시
	readValue(File객체,DTO혹은 MAP):JSON파일(.json)에 있는 내용을 자바객체로 읽어들일때
	readValue(JSON형식 문자열,DTO혹은 MAP):JSON형식의 문자열을 자바객체로 읽어 들일때
 */

@Controller
public class AjaxController {

	@Autowired
	private OneMemoService service;

	// void도 가능 결과값 그냥 뿌릴꺼임
	/*
	 * @RequestMapping("/Ajax/NoAjax.do") public void noAjax(@RequestParam Map
	 * map,HttpServletResponse resp) throws IOException {
	 * 
	 * resp.setContentType("text/html; charset=UTF-8"); PrintWriter pw =
	 * resp.getWriter();
	 * 
	 * boolean result = service.isLogin(map);
	 * 
	 * if(result) { pw.println("<h2>"+map.get("id")+"님 환영합니다 </h2>");
	 * 
	 * }else { pw.println("<script>"); pw.println("alert('로그인 실패!')");
	 * pw.println("history.back()"); pw.println("</script>"); } pw.close(); }
	 */

	@RequestMapping("/Ajax/NoAjax.do")
	public String noAjax(@RequestParam Map map, Model model) {

		boolean result = service.isLogin(map);

		model.addAttribute("isLogin", result ? map.get("id") + "님 환영합니다." : "회원 정보 불일치");

		return "chap12_ajax/Ajax";
	}

	/*
	 * @RequestMapping("/Ajax/AjaxText.do") public void ajaxText(@RequestParam Map
	 * map, HttpServletResponse resp) throws IOException {
	 * 
	 * resp.setContentType("text/html; charset=UTF-8"); PrintWriter out =
	 * resp.getWriter();
	 * 
	 * boolean result = service.isLogin(map); // out.print(result ? "Yes":"No"); //
	 * out.close();
	 * 
	 * out.print(result? map.get("id")+"님 즐감" : "회원 가입하세요"); out.close(); }
	 */

	@RequestMapping(value = "/Ajax/AjaxText.do", produces = "text/html; charset=UTF-8")
	@ResponseBody()
	public String ajaxText(@RequestParam Map map) {
		System.out.println("응 받았어~");
		boolean result = service.isLogin(map);

//		return result ?  "Y" : "N" ;

		return result ? map.get("id") + "님 즐감이여!" : "가입부터 !!";
	}

	@Autowired
	ObjectMapper mapper;

	@RequestMapping(value = "/Ajax/AjaxJson.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String ajaxJson(@RequestParam Map map) throws JsonProcessingException {
//		
		boolean result = service.isLogin(map);
//		
////		return  result ? map.get("id")+"님 로그인됨 ㅇㅅㅇ" : "가입하셈 ㅇㅅㅇ";
//		return String.format("{\"isLogin\": \"%s\"}", result? "ㅎㅇ 로긴됨 ㅇㅅㅇ" : "가입하셈 ㅇㅅㅇ");

		map.put("isLogin", result ? "ㅎㅇ 로긴됨 ㅇㅅㅇ" : "가입하셈 ㅇㅅㅇ");

		return mapper.writeValueAsString(map);
	}

	@RequestMapping(value = "/Ajax/AjaxJsonArray.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String ajaxJsonArray(@RequestParam Map map, HttpServletRequest req) throws JsonProcessingException {

		List<OneMemoDTO> lists = service.selectList(map, req, 1).getLists();

		String parsed = mapper.writeValueAsString(lists);
		System.out.println("전환된 데이터 :" + parsed);

		return mapper.writeValueAsString(lists);
	}

	/*
	 * 문]
	 * 
	 * <option value="j01">자바</option> <option value="j02">JSP</option> <option
	 * value="j03">스프링</option> 닷넷과정 선택시 커리큘럼에 <option value="d01">C#</option>
	 * <option value="d02">ASP.NET</option> <option value="d03">WPF4</option>
	 * 사물인터넷과정 선택시 커리큘럼에 <option value="i01">라즈베리 파이</option> <option
	 * value="i02">파이썬</option> 이 보이도록 AJAX로구현하여라, 단, 서버에서 데이타를 JSON타입으로 받아라.
	 * 
	 * 
	 * 
	 */

	@RequestMapping(value = "/Ajax/AjaxExam.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String ajaxExam(@RequestParam Map map, HttpServletRequest req) throws JsonProcessingException {

		System.out.println("그래서 너 뭐나옴 ? " + map.get("course"));
		map.put("curriculumsVal", "");
		map.put("curriculumsName", "");
		switch (map.get("course").toString()) {
		case "java":

			map.put("curriculumsVal", Arrays.asList("j01", "j02", "j03"));
			map.put("curriculumsName", Arrays.asList("자바", "JSP", "스프링"));
			break;
		case "dotnet":

			map.put("curriculumsVal", Arrays.asList("d01", "d02", "d03"));
			map.put("curriculumsName", Arrays.asList("C#", "ASP.NET", "WPF4"));

			break;

		default:
			// iot

			map.put("curriculumsVal", Arrays.asList("i01", "i02"));
			map.put("curriculumsName", Arrays.asList("라즈베리 파이", "파이썬"));

			break;
		}

		return mapper.writeValueAsString(map);
	}

	@RequestMapping(value = "/Ajax/form.do")
	public String form(OneMemoDTO dto, Model model, HttpServletRequest req)
			throws StreamWriteException, DatabindException, IOException {
		// String res = req.getServletContext
		String res = req.getServletContext().getRealPath("/resources");
		System.out.println();
		mapper.writeValue(new File(res+"/onememo.json"), dto);

		String json = mapper.writeValueAsString(dto);
		System.out.println(json);
		model.addAttribute("formRequestResult", json);
		return "chap12_ajax/Ajax";
	}
	/*
	 * @RequestMapping("/Ajax/AjaxKeyValue.do") public @ResponseBody OneMemoDTO
	 * ajaxKeyValue(OneMemoDTO dto) {
	 * 
	 * 
	 * return dto; }
	 */

	// JSON 데이터를 받을때는 ReuqestBody로 반드시 받을 것!!!
	/*
	 * @RequestMapping(value= "/Ajax/AjaxDataJson.do",produces =
	 * "application/json; charset=UTF-8") public @ResponseBody OneMemoDTO
	 * ajaxKeyValue(@RequestBody OneMemoDTO dto) { //@RequestParam으로는 못받음 JSON 형식이니까
	 * Body 로 받아야 함!!! 헷갈리니 주의!!
	 * 
	 * return dto; }
	 */
	@RequestMapping(value = "/Ajax/AjaxDataJson.do", produces = "application/json; charset=UTF-8")
	public @ResponseBody Map ajaxKeyValue(@RequestBody Map map) {
		// @RequestParam으로는 못받음 JSON 형식이니까 Body 로 받아야 함!!! 헷갈리니 주의!!

		return map;
	}

	@RequestMapping(value = "/Ajax/AjaxDataArray.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Map> ajaxDataArray() {
		System.out.println("rr");
		List<Map> lists = new Vector<>();
		Map map = new HashMap();
		map.put("id", "LEE");
		map.put("name", "이길동");
		lists.add(map);

		return lists;
	}

	
	//https://www.jsonschema2pojo.org/
	@RequestMapping(value = "/Ajax/AjaxJsonToJava.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map ajaxJsonToJava(HttpServletRequest req) throws StreamReadException, DatabindException, IOException {
		
		String res = req.getServletContext().getRealPath("/resources");
//		//반환타입으로
//		OneMemoDTO dto =  mapper.readValue(new File(res+File.separator+"onememo.json"),OneMemoDTO.class );
//		String json = mapper.writeValueAsString(dto);
//		System.out.println(json);
		
		Map mymap =  mapper.readValue(new File(res+File.separator+"onememo.json"),Map.class);
		String json = mapper.writeValueAsString(mymap);
		System.out.println(json);
		return mymap;
	}

}
