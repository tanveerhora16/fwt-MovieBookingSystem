package com.yash.mbs.service;

public interface ShowService {

	public int displayShows(String screenName);

	public boolean checkScreenAvailable(String screenName);

	public boolean addShows(String screenName);

}
