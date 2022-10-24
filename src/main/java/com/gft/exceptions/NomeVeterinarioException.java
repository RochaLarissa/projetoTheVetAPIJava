package com.gft.exceptions;

public class NomeVeterinarioException extends RuntimeException{
	
	private static final long serialVersionUID = -623338538158836091L;

	private String message;

	public NomeVeterinarioException(String message) {
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
