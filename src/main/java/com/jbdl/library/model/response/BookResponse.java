package com.jbdl.library.model.response;

import java.util.Date;

public class BookResponse implements Response {
	int id;
	String name;
	int totalPage;
	String language;
	Boolean available;
	String genre;
	int isbnNo;
	Date publishedDate;
	private AuthorResponse author;

	public BookResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public BookResponse(int id, String name, int totalPage, String language, Boolean available, String genre, int isbnNo,
			Date publishedDate, AuthorResponse author) {
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

	public AuthorResponse getAuthor() {
		return author;
	}

	public void setAuthor(AuthorResponse author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookRequest [id=" + id + ", name=" + name + ", totalPage=" + totalPage + ", language=" + language
				+ ", available=" + available + ", genre=" + genre + ", isbnNo=" + isbnNo + ", publishedDate="
				+ publishedDate + ", author=" + author + "]";
	}
}
