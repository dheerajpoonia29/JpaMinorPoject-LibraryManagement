package com.jbdl.library.model.request;

import java.util.Date;

public class CardRequest {
	boolean status;
	Date validUpto;
	int studentId;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CardRequest [status=" + status + ", validUpto=" + validUpto + ", studentId=" + studentId + "]";
	}
	
	
}
