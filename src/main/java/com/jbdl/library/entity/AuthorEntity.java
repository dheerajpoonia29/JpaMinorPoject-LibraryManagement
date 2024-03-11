package com.jbdl.library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class AuthorEntity {
	@Id
	@GeneratedValue
	@Column(name="id")
	Integer id;
	
	@Column(name="age")
	int age;
	
	@Column(name="name")
	String name;
	
	@Column(name="email")
	String email;
	
	@Column(name="country")
	String country;
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private BookEntity authorBook;

	public AuthorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorEntity(int id, int age, String name, String email, String country) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.email = email;
		this.country = country;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

//	public BookEntity getAuthorBook() {
//		return authorBook;
//	}
//
//	public void setAuthorBook(BookEntity authorBook) {
//		this.authorBook = authorBook;
//	}

	@Override
	public String toString() {
		return "AuthorEntity [id=" + id + ", age=" + age + ", name=" + name + ", email=" + email + ", country="
				+ country + ", authorBook=" + 
				"]";
//				authorBook + "]";
	}
	
}
