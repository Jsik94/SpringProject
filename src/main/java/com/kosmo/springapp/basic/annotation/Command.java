package com.kosmo.springapp.basic.annotation;


public class Command {
	/*※
	폼의 파라미터명과 속성(멤버변수)을 일치시켜야한다.
    체크박스 같은 경우는 타입을 String[]해도 무방
	String으로 받는 경우 ,(콤마)구분해서 선택된 모든 값들이
	저장된다.
	 */
	
	private String name;
	private String years;
	private String gender;
	private String grade;
	private String inters;
	private String self;
	
	
	
	@Override
	public String toString() {
		return "Command [name=" + name + ", years=" + years + ", gender=" + gender + ", grade=" + grade + ", inters="
				+ inters + ", self=" + self + "]";
	}

	public Command() {
		// TODO Auto-generated constructor stub
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getInters() {
		return inters;
	}
	public void setInters(String inters) {
		this.inters = inters;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	

}
