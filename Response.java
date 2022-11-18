package com.bnt.exception;

public class Response {
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Response(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Response() {
		super();
		
	}
	@Override
	public String toString() {
		return "Response [code=" + code + ", msg=" + msg + "]";
	}
	

}
