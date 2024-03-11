package com.jbdl.library.entity;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity {
	@Id
	@GeneratedValue
	@Column(name="id")
	Integer id;
	
	@Column(name="name")
	String name;
	
	@Column(name="total_page")
	int totalPage;
	
	@Column(name="language")
	String language;
	
	@Column(name="available")
	Boolean available;
	

	@Column(name="genre")
	String genre;

	@Column(name="isbn_no")
	int isbnNo;
	

	@Column(name="published_date")
	Date publishedDate;
	
//	@OneToOne(mappedBy = "authorBook")
	@OneToOne()
	@Cascade(value = CascadeType.PERSIST)
	private AuthorEntity author;
	
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookEntity(int id, String name, int totalPage, String language, Boolean available, String genre, int isbnNo,
			Date publishedDate, AuthorEntity author) {
		super();
		this.id = id;
		this.name = name;
		this.totalPage = totalPage;
		this.language = language;
		this.available = available;
		this.genre = genre;
		this.isbnNo = isbnNo;
		this.publishedDate = publishedDate;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(int isbnNo) {
		this.isbnNo = isbnNo;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public AuthorEntity getAuthor() {
		return author;
	}

	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", totalPage=" + totalPage + ", language=" + language
				+ ", available=" + available + ", genre=" + genre + ", isbnNo=" + isbnNo + ", publishedDate="
				+ publishedDate + ", author=" + author + "]";
	}
	
}
