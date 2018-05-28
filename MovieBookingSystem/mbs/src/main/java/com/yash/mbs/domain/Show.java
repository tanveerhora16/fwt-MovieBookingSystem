package com.yash.mbs.domain;

import java.sql.Time;

public class Show {
	private int id;
	private Time showTime;

	public Show(int id, Time showStartTime) {
		this.showTime = showStartTime;
		System.out.println(this.showTime + " " + showStartTime);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}


}