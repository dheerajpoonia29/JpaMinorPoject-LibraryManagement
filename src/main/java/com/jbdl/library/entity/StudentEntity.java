package com.jbdl.library.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//@Data
@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue
	@Column(name="id")
	Integer id;
	
	@Column(name="age")
	int age;
	
	@Column(name="name")
	String name;
	
	@Column(name="country")
	String country;
	
	@Column(name="email", unique=true)
	String email;
	
	@Column(name="phone_no")
	int phoneNo;
	
	@Column(name="created_on")
	Date createdOn;
	
	@Column(name="updated_on")
	Date updatedOn;
	
	@OneToOne
//	@PrimaryKeyJoinColumn
	private CardEntity studentCard;

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentEntity(int age, String name, String country, String email, int phoneNo, Date createdOn,
			Date updatedOn) {
		super();
		this.age = age;
		this.name = name;
		this.country = country;
		this.email = email;
		this.phoneNo = phoneNo;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public CardEntity getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(CardEntity studentCard) {
		this.studentCard = studentCard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", age=" + age + ", name=" + name + ", country=" + country + ", email="
				+ email + ", phoneNo=" + phoneNo + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn
				+ "]";
//				+ ", studentCard=" + studentCard + "]";
	}

	
	
}
