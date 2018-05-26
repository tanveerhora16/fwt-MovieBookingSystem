package com.yash.mbs.daoimpl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.yash.mbs.dao.MovieDao;
import com.yash.mbs.domain.Movie;


public class MovieDaoImplTest {
	private MovieDao movieDao = new MovieDaoImpl();

	@Test
	public void insert_GivenScreenNameAndMovieObject_ShouldReturnTrueIfAdded() {
		String screenName = "Screen 1";
		Movie movie = new Movie(101, "deadpool", "balaji", "03:00:00");
		assertTrue(movieDao.insertMovie(movie, screenName));
	}

}
