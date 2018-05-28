package com.yash.mbs.serviceimpl;

import java.util.List;

import com.yash.mbs.dao.ScreenDao;
import com.yash.mbs.daoimpl.ScreenDaoImpl;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.exception.ScreenAlreadyAvailableException;
import com.yash.mbs.exception.ScreenLimitException;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	private ScreenDao screenDao;
	List<Screen> listOfScreens;

	public ScreenServiceImpl(ScreenDao screenDao) {
		this.screenDao = screenDao;
	}

	public ScreenServiceImpl() {
		this.screenDao = new ScreenDaoImpl();
	}

	public int addScreen(Screen screen) {

		int affectedRows = 0;

		if (screen == null) {
			throw new NullPointerException("screen cannot be null");
		}

		if (screen.getScreenId() == 0) {
			throw new EmptyException("Screen cannot be empty");
		}
		if (screenDao.getScreens().size() >= 3) {

			throw new ScreenLimitException("Can't add more than 3 screen");
		}

		if (screenDao.getScreens().size() <= 3) {
			List<Screen> listOfScreens = screenDao.getScreens();
			for (Screen screenTest : listOfScreens) {
				if (screenTest.getScreenName().equalsIgnoreCase(screen.getScreenName())) {
					throw new ScreenAlreadyAvailableException(
							"Screen name already exist, it should be unique");
				}
			}

			affectedRows = screenDao.addScreen(screen);
		}

		System.out.println("AffectedRows" + affectedRows);

		return affectedRows;

	}

	public int addMovieToScreen(Movie movie, Screen screen) {
		if (movie == null) {
			throw new NullPointerException("Movie should be added to screen, it can't be null");
		}
		return 0;
	}

}
