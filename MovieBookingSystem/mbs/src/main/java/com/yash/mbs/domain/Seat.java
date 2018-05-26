package com.yash.mbs.domain;

public class Seat {

	private int screenId;
	private Boolean isBooked;
	public Seat(int screenId, Boolean isBooked) {
		super();
		this.screenId = screenId;
		this.isBooked = isBooked;
	}
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public Boolean getIsBooked() {
		return isBooked;
	}
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	
}
