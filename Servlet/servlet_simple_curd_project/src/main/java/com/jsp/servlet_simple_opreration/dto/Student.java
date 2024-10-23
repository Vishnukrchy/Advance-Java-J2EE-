package com.jsp.servlet_simple_opreration.dto;

public class Student {
	private String name;
	private String email;
	private String phone;
	private String degree;
	private String branch;
	private String gender;
	private String password;

public	Student(){
		
	}

	public Student(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Student(String name, String email, String phone, String degree, String branch, String gender,
			String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.degree = degree;
		this.branch = branch;
		this.gender = gender;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", phone=" + phone + ", degree=" + degree + ", branch="
				+ branch + ", gender=" + gender + ", password=" + password + "]";
	}


	
}
