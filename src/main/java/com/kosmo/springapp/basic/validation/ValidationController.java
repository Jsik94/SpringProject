package com.kosmo.springapp.basic.validation;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {

	// 방법1] 스프링 API사하지 않고 유효성 검증하기
	/*
	@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand cmd, Model model) {

		System.out.println("성별" + cmd.getGender());
		System.out.println("관심사항" + cmd.getInters());
		
	
		if (!validate(cmd, model)) {
			// 유효성 실패시
			//${param.inters} 로 표현하는 경우 여러 값중 앞에 값 하나만 가져온다.
			//따라서 request 영역에 저장해야된다.
			//따라서 request에 따로 담아줘야함
			model.addAttribute("inters", Arrays.toString(cmd.getInters()));
			return "chap09_validation/Validation";
		}
		model.addAttribute("inters",cmd.getInters());
		
		model.addAttribute("self", cmd.getSelf().replace("\r\n", "<br/>"));
		System.out.println(cmd.getSelf().replace("\r\n", "<br/>"));
		// 뷰 정보 반환
		return "chap09_validation/ValidationComplete";
	}

	
	
	private boolean validate(FormCommand cmd, Model model) {
		boolean result = true;

		if (cmd.getName().trim().isEmpty()) {

			model.addAttribute("nameError", "이름을 입력하세요");
			return false;
		}

		if (cmd.getYears().trim().isEmpty()) {
			model.addAttribute("yearsError", "나이를 입력하세요");
			return false;
		} else {

			try {
				Integer.parseInt(cmd.getYears().trim());

			} catch (Exception e) {
				model.addAttribute("yearsError", "나이는 숫자입니다.");
				return false;
			}
		}

		if (cmd.getGender()==null) {

			model.addAttribute("genderError", "성별을 선택하세요.");
			return false;
		}
		
		if (cmd.getInters()==null) {

			model.addAttribute("intersError", "관심사항을 선택하세요.");
			return false;
		}else {
			
			if(cmd.getInters().length <2) {
				
				model.addAttribute("intersError", "관심사항은 두개 이상입니다.");
				return false;
			}
			
		}
		
		if (cmd.getGrade().isBlank()) {

			model.addAttribute("gradeError", "학력을 선택하세요.");
			return false;
		}
		
		if (cmd.getSelf().trim().isBlank()) {

			model.addAttribute("selfError", "자기소개를 선택하세요.");
			return false;
		}


		return result;
	}
	
*/
	
	@Autowired
	private FormValidator validator;
	
	
	//순서가 중요하다
	@RequestMapping("/Validation/ValidationCheck.do")
	public String execute(FormCommand cmd,BindingResult errors, Model model) {
		System.out.println("validation 접속");
		/*
		 * 	내가 만든 validator에 validate 호출
		 * 	
		 * 
		 */
		System.out.println("Validate Test"+validator);
		validator.validate(cmd, errors);
		/*
		 *  한번이라도 rejectValue가 나온다면 이전페이지로 이동 
		 *  가지고있는
		 * 
		 */
		
		if(errors.hasErrors()) {
			model.addAttribute("inters", Arrays.toString(cmd.getInters()));
			return "chap09_validation/Validation";
		}
		model.addAttribute("inters",cmd.getInters());
		model.addAttribute("self", cmd.getSelf().replace("\r\n", "<br/>"));
		// 뷰 정보 반환
		return "chap09_validation/ValidationComplete";
	}

}
