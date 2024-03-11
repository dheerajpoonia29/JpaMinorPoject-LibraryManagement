package com.jbdl.library.model.request;

public class StudentRequest {
	int age;
	String name;
	String country;
	String email;
	int phoneNo;
	CardRequest card;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "StudentRequest [age=" + age + ", name=" + name + ", country=" + country + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", card=" + card + "]";
	}


	
}
