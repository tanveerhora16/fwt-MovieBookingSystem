package com.yash.mbs.domain;

public class Screen {

	private int screenId;
	private String screenName;
	 Movie movie;

	public Screen(int i, String name) {
		this.screenId = i;
		this.screenName = name;
	}

	public Screen() {
		// TODO Auto-generated constructor stub
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", screenName=" + screenName + "]";
	}

}