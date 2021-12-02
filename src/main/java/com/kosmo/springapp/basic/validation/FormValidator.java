package com.kosmo.springapp.basic.validation;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/*
 * 	특정폼에서 유효성검사를 하기 위한 클래스
 *  상속을 받으면 폼값을 체크할 수있게 인터페이스가 도와줌
 * 	특정 DTO 계열클래스(커맨드객체)의 유효성을 검증할 수 있음
 *  
 */

public class FormValidator implements Validator{

	
	
	
	//supports가 true 가 될때만 validate 가 작동함
	
	public FormValidator() {
		// TODO Auto-generated constructor stub
		
		System.out.println(this.getClass().getName()+"| Constructed ");
	}

	@Override
	public boolean supports(Class<?> command) {
		
		// TODO Auto-generated method stub
		
		//해당 파라미터 command 클래스가 같은지 확인한다. 
		//FormCommand의 자식클래스도 포함됨 instance of 와같음
//		return FormCommand.class.isAssignableFrom(command);
		
		//정확히 본인과 같은 타입만 검증하겠다는 의미 
		return FormCommand.class.equals(command);
	}

	@Override
	public void validate(Object command, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+"| validate | Start");
		
		FormCommand cmd =(FormCommand)command;
		
		if(cmd.getName().trim().equals("")) {
			
			errors.rejectValue("name","nameError");
		}
		

		if (cmd.getYears().trim().isEmpty()) {
			errors.rejectValue("years","yearsError");
		} else {

			try {
				Integer.parseInt(cmd.getYears().trim());

			} catch (Exception e) {
				errors.rejectValue("years", "yearsNotNumber");
			}
		}

		if (cmd.getGender()==null) {

			errors.rejectValue("gender","genderError");
		}
		
		if (cmd.getInters()==null) {

			errors.rejectValue("inters","intersError");
		}else {
			
			if(cmd.getInters().length <2) {
				
				errors.rejectValue("inters","intersLackError");
			}
			
		}
		
		if (cmd.getGrade().isEmpty()) {

			errors.rejectValue("grade","gradeError");
		}
		
		if (cmd.getSelf().trim().isBlank()) {

			errors.rejectValue("self","selfError");
		}
		
		
		System.out.println(this.getClass().getName()+"| validate | Done");
	}

}
