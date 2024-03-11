package com.jbdl.library.model.response;

public class MainResponse {
	String msg;
//	HttpStatus status;
	Response resDetail;

	public MainResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainResponse(String msg, Response resDetail) {
		super();
//		this.status = status;
		this.msg = msg;
		this.resDetail = resDetail;
	}

//	public HttpStatus getStatus() {
//		return status;
//	}
//	public void setStatus(HttpStatus status) {
//		this.status = status;
//	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Response getResDetail() {
		return resDetail;
	}

	public void setResDetail(Response resDetail) {
		this.resDetail = resDetail;
	}
}
