package com.yash.mbs.exception;

public class ScreenLimitException extends RuntimeException {

	
	private static final long serialVersionUID = 609985513747311014L;
	

	public ScreenLimitException (String message){
		super(message);
	}
}
