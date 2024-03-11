package com.jbdl.library.model.response;

import java.util.Date;

public class StudentResponse implements Response {
	int id;
	int age;
	String name;
	String country;
	String email;
	int phoneNo;
	Date createdOn;
	Date updatedOn;
	CardResponse card;

	public StudentResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentResponse(int id, int age, String name, String country, String email, int phoneNo, Date createdOn,
			Date updatedOn) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.country = country;
		this.email = email;
		this.phoneNo = phoneNo;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	public CardResponse getCard() {
		return card;
	}

	public void setCard(CardResponse card) {
		this.card = card;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

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
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StudentResponse [id=" + id + ", age=" + age + ", name=" + name + ", country=" + country + ", email="
				+ email + ", phoneNo=" + phoneNo + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}

	
}
