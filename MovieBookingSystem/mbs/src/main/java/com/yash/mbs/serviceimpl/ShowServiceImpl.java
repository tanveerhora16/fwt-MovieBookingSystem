package com.yash.mbs.serviceimpl;

import java.sql.Time;

import com.yash.mbs.dao.ShowDao;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.service.ShowService;


public class ShowServiceImpl implements ShowService {

	private ShowDao showDao;

	public ShowServiceImpl(ShowDao showDao) {

	}

	@Override
	public int displayShows(String screenName) {
		if (screenName == null) {
			throw new NullPointerException("Screen Name can not be null");
		}
		createPossibleShows(screenName);
		return 0;
	}

	private void createPossibleShows(String screenName) {
		Screen screen = showDao.getScreen(screenName);
		String durationinString = screen.getMovie().getDuration();
		String[] timeSlices = durationinString.split(":");
		int hour = Integer.parseInt(timeSlices[0]);
		int min = Integer.parseInt(timeSlices[1]);
		int sec = Integer.parseInt(timeSlices[2]);
		Time movieDuration = new Time(hour, min, sec);
		Time showStartTime = new Time(9, 00, 00);
		Time showEndTime = new Time(0, 0, 0);
		for (int i = 0; i < 4; i++) {
			showEndTime.setHours(showStartTime.getHours() + movieDuration.getHours());
			System.out.println(showStartTime + " to " + showEndTime);
			showStartTime.setHours(showStartTime.getHours() + 4);
		}
	}
	
	@Override
	public boolean checkScreenAvailable(String screenName) {
		boolean isAvailable = false;
		Screen screen = showDao.getScreen(screenName);

		if (screen.getScreenName().equalsIgnoreCase(screenName)) {
			isAvailable = true;
		}
		return isAvailable;
	}
	
	public boolean addShows(String screenName) {
		boolean isShowsAdded = false;
		if(showDao.addShows(screenName)) {
			isShowsAdded=true;
		}
		return isShowsAdded;
	}


}
