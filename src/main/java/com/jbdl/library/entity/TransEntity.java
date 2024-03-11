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
@Table(name = "transaction")
public class TransEntity {
	@Id
	@GeneratedValue
	@Column(name="id")
	Integer id;
	
	@OneToOne()
	@Cascade(value = CascadeType.PERSIST)
	BookEntity book;
	
	@OneToOne()
	@Cascade(value = CascadeType.PERSIST)
	CardEntity card;
	
	@Column(name="trans_date")
	Date transDate;
	
	@Column(name="book_due_date")
	Date dueDate;
	
	@Column(name="is_issued")
	boolean isIssued;
	
	@Column(name="is_returned")
	boolean isReturned;
	
	@Column(name="fine")
	int fineAmount;
	
	@Column(name="status")
	boolean status;
	
	@Column(name="created_on")
	Date createOn;
	
	@Column(name="updated_on")
	Date updatedOn;

	public TransEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransEntity(Integer id, BookEntity book, CardEntity card, Date transDate, Date dueDate, boolean isIssued,
			boolean isReturned, int fineAmount, boolean status, Date createOn, Date updatedOn) {
		super();
		this.id = id;
		this.book = book;
		this.card = card;
		this.transDate = transDate;
		this.dueDate = dueDate;
		this.isIssued = isIssued;
		this.isReturned = isReturned;
		this.fineAmount = fineAmount;
		this.status = status;
		this.createOn = createOn;
		this.updatedOn = updatedOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public CardEntity getCard() {
		return card;
	}

	public void setCard(CardEntity card) {
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

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
}
