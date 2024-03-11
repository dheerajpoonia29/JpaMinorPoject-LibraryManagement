package com.jbdl.library.model.response;

import java.util.Date;

public class TransResponse {
	BookResponse book;
	CardResponse card;
	Date transDate;
	Date dueDate;
	boolean isIssued;
	boolean isReturned;
	int fineAmount;
	boolean status;
	Date createdOn;
	Date updateOn;
	
	public TransResponse(BookResponse book, CardResponse card, Date transDate, Date dueDate, boolean isIssued,
			boolean isReturned, int fineAmount, boolean status, Date createdOn, Date updateOn) {
		super();
		this.book = book;
		this.card = card;
		this.transDate = transDate;
		this.dueDate = dueDate;
		this.isIssued = isIssued;
		this.isReturned = isReturned;
		this.fineAmount = fineAmount;
		this.status = status;
		this.createdOn = createdOn;
		this.updateOn = updateOn;
	}
	public BookResponse getBook() {
		return book;
	}
	public void setBook(BookResponse book) {
		this.book = book;
	}
	public CardResponse getCard() {
		return card;
	}
	public void setCard(CardResponse card) {
		this.card = card;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	
	
}
