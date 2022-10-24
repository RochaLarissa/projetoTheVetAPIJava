package com.gft.exceptions;

public class NomeCachorroException extends RuntimeException {

	private static final long serialVersionUID = 4157776716014642904L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NomeCachorroException(String message) {
		super(message);
		this.message = message;
	}

	

}
