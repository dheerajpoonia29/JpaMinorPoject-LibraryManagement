package com.jbdl.library.model.response;

import java.util.Date;

public class CardResponse implements Response {
	int id;
	boolean status;
	String email;
	Date validUpto;
	Date createdOn;
	Date updatedOn;
	StudentResponse student;
	
	public CardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardResponse(int id, boolean status, String email, Date validUpto, Date createdOn, Date updatedOn, StudentResponse student) {
		super();
		this.id = id;
		this.status = status;
		this.email = email;
		this.validUpto = validUpto;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.student = student;
	}

	public StudentResponse getStundent() {
		return student;
	}

	public void setStundent(StudentResponse stundent) {
		this.student = stundent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
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
		return "CardResponse [id=" + id + ", status=" + status + ", email=" + email + ", validUpto=" + validUpto
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}
