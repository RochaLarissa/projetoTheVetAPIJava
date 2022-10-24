package com.gft.exceptions;

public class EntityNotFoundException extends ClienteException{

	private static final long serialVersionUID = 7850522856336126736L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
