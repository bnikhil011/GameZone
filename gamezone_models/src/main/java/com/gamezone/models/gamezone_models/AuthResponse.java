package com.gamezone.models.gamezone_models;

public class AuthResponse {

	private String jwt;
	private String errorMsg;
	
	

	

	public AuthResponse(String jwt, String errorMsg) {
		super();
		this.jwt = jwt;
		this.errorMsg = errorMsg;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String token) {
		this.jwt = token;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
