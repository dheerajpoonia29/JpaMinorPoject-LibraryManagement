package com.jbdl.library.model.request;

import java.util.Date;

import com.jbdl.library.model.response.AuthorResponse;

public class BookRequest {
	String name;
	int totalPage;
	String language;
	Boolean available;
	String genre;
	int isbnNo;
	Date publishedDate;
	int authorId;

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

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "BookRequest [name=" + name + ", totalPage=" + totalPage + ", language=" + language + ", available="
				+ available + ", genre=" + genre + ", isbnNo=" + isbnNo + ", publishedDate=" + publishedDate
				+ ", authorId=" + authorId + "]";
	}
	
}
