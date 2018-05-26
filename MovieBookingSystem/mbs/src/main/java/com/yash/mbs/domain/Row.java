package com.yash.mbs.domain;

import java.util.List;

public class Row {

	private int rowId;
	private String category;
	private List<Seat> seats;
	public Row(int rowId, String category, List<Seat> seats) {
		super();
		this.rowId = rowId;
		this.category = category;
		this.seats = seats;
	}
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	
}
