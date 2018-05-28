package com.yash.mbs.dao;

import com.yash.mbs.domain.Screen;

public interface ShowDao {

	Screen getScreen(String screenName);
	boolean addShows(String screenName);
}
