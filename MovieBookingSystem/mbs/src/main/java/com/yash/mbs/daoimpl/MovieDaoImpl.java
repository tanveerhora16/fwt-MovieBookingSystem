package com.yash.mbs.daoimpl;

import java.util.List;

import com.yash.mbs.dao.MovieDao;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.util.JSONUtil;

public class MovieDaoImpl implements MovieDao {

	private JSONUtil jsonUtil;
	
	 public MovieDaoImpl() {
		jsonUtil = new JSONUtil();
	}
	
	@Override
	public boolean insertMovie(Movie movie, String screenName) {
		boolean isInserted = false;
		List<Screen> listOfScreens =  jsonUtil.readListOfScreen();
		for (Screen screenList : listOfScreens) {
			if(screenList.getScreenName().equalsIgnoreCase(screenName)){
			screenList.setMovie(movie);
			}
		}
		isInserted=jsonUtil.updateListOfScreens(listOfScreens);
		return isInserted;
	}

}
