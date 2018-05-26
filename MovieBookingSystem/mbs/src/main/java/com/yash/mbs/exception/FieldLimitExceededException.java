package com.yash.mbs.exception;

public class FieldLimitExceededException extends RuntimeException {

	
	private static final long serialVersionUID = -2477707991759797684L;

	public FieldLimitExceededException(String message){
		super(message);
	}
}
