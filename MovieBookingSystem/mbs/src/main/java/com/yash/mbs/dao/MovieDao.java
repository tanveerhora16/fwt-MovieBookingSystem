package com.yash.mbs.dao;

import com.yash.mbs.domain.Movie;

public interface MovieDao {

	boolean insertMovie(Movie movie, String screenName);

}
