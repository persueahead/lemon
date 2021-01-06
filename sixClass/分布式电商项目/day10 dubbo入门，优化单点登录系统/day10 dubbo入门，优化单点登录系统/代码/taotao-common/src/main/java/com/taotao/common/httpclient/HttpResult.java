package com.taotao.common.httpclient;

public class HttpResult {

	private int code;
	private String content;
	public int getCode() {
		return code;
	}
	public HttpResult(int code, String content) {
		super();
		this.code = code;
		this.content = content;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
