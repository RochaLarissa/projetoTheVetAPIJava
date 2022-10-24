package com.gft.exceptions;

public class CachorroException extends RuntimeException{
	
	private static final long serialVersionUID = -623338538158836091L;

	private String message;

	public CachorroException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
