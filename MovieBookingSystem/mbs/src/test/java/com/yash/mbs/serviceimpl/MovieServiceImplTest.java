package com.yash.mbs.serviceimpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

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
	public void addMovie_shouldThrowEmptyException_WhenScreenNameIsEmpty() {
		movie = new Movie(112, "raazi", "abc", "02:00:00");
		String screenName = "";
		movieService.addMovie(movie, screenName);
	}
	
	@Test
	public void addMovie_shouldRteurnTrue_WhenMovieAndScreenObjectIsGiven() {
		 movie = new Movie(101, "deadpool", "balaji", "03:00:00");
		String screenName = "Screen 1";
		when(movieDao.insertMovie(movie, screenName)).thenReturn(true);
		assertTrue(movieService.addMovie(movie, screenName));
	}

}
