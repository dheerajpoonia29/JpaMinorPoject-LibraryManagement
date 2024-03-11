package com.jbdl.library.entity;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class CardEntity {
	@Id
	@GeneratedValue
	@Column(name="id")
	Integer id;
	
	@Column(name="status")
	boolean status;
	
	@Column(name="email", unique=true)
	String email;
	
	@Column(name="vaild_upto")
	Date validUpto;
	
	@Column(name="created_on")
	Date createdOn;
	
	@Column(name="updated_on")
	Date updatedOn;

	//student_id
//	@OneToOne(mappedBy = "studentCard")
	@OneToOne()
	@Cascade(value = CascadeType.PERSIST)
	private StudentEntity student;

	public CardEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardEntity(boolean status, String email, Date validUpto, Date createdOn, Date updatedOn,
			StudentEntity student) {
		this.status = status;
		this.email = email;
		this.validUpto = validUpto;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.student = student;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getStatus() {
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
		return "CardEntity [id=" + id + ", status=" + status + ", email=" + email + ", validUpto=" + validUpto
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", student=" + student + "]";
	}
	
	
	
}
