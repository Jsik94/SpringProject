package com.kosmo.springapp.basic.validation;

public class FormCommand {
	private String name;
	private String years;
	private String[] inters;
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	private String grade;
	private String self ;
	
	
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
	public String[] getInters() {
		return inters;
	}
	public void setInters(String[] inters) {
		this.inters = inters;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	
	
	@Override
	public String toString() {
		return "FormCommand [name=" + name + ", years=" + years + ", inters=" + inters + ", grade=" + grade + ", self="
				+ self + "]";
	}
	
	
}
