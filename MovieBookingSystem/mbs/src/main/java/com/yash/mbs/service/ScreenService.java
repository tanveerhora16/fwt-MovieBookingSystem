package com.yash.mbs.service;

import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;

public interface ScreenService {

	public int addScreen(Screen screen);

	public int addMovieToScreen(Movie movie, Screen screen);

}
