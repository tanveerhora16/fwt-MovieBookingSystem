package com.yash.mbs.exception;

public class ScreenAlreadyAvailableException extends RuntimeException{

	
	private static final long serialVersionUID = 6380999394968308000L;

	public ScreenAlreadyAvailableException (String message){
		super(message);
	}
	
}
