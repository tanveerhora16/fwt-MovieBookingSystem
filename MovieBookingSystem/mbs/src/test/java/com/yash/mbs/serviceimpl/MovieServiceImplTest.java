package com.yash.mbs.serviceimpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.mbs.dao.MovieDao;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.service.MovieService;

public class MovieServiceImplTest {

	@Mock
	private MovieDao movieDao;

	@InjectMocks
	private MovieService movieService = new MovieServiceImpl();

	private Screen screen;

	private Movie movie;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = NullPointerException.class)
	public void addMovie_ShouldThrowNullException_WhenBothScreenAndMovieObjectIsNull() {
		movie = null;
		String screenName = null;
		movieService.addMovie(movie, screenName);
	}

	@Test(expected = NullPointerException.class)
	public void addMovie_GivenMovieObjectIsNull_ThrowNullFieldException() {
		Movie movie = null;
		String screenName = "Screen 1";
		movieService.addMovie(movie, screenName);
	}

	@Test(expected = EmptyException.class)
	public void addMovie_GivenScreenNameIsEmptyAndMovieObjectIsCorrect_ThrowEmptyFieldException() {
		movie = new Movie(112, "1:50:00", "abc", "John Abrahim");
		String screenName = "";
		movieService.addMovie(movie, screenName);
	}

}
