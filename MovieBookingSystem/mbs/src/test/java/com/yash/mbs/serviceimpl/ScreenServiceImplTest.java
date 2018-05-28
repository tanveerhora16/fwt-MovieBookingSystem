package com.yash.mbs.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.mbs.dao.ScreenDao;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.exception.ScreenAlreadyAvailableException;
import com.yash.mbs.exception.ScreenLimitException;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImplTest {

	@Mock
	private ScreenDao screenDao;

	@InjectMocks
	private ScreenService screenService = new ScreenServiceImpl();

	private Screen screen;

	private Movie movie;

	@Before
	public void init() {
		
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = NullPointerException.class)
	public void addScreen_shouldThrowNullException_WhenScreenObjectIsNull() {
		screen = null;
		screenService.addScreen(screen);
	}

	@Test(expected = EmptyException.class)
	public void addScreen_shouldThrowEmptyException_WhenScreenObjectIsEmpty() {
		screen = new Screen();
		screenService.addScreen(screen);
	}

	@Test
	public void addScreen_shouldReturnOne_WhenScreenObjectIsGiven() {

		screen = new Screen();
		screen.setScreenId(101);
		screen.setScreenName("Theatre-1");

		when(screenDao.addScreen(screen)).thenReturn(1);
		assertEquals(1, screenService.addScreen(screen));
	}

	
	@Test(expected = ScreenAlreadyAvailableException.class)
	public void addScreen_GivenScreenNameIsCorrect_ThrowValueAlreadyAvailableException() {
		List<Screen> screenList = Arrays.asList(new Screen(101, "screen 2"));
		when(screenDao.getScreens()).thenReturn(screenList);
		screenService.addScreen(new Screen(101, "screen 2"));
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = ScreenLimitException.class)
	public void addScreen_shouldThrowScreenLimitException_WhenOperatorAddMoreThanThreeScreen() {
		screen = new Screen(101, "Theatre-1");
		List<Screen> alreadyExistScreen = Arrays.asList(new Screen(102, "Theatre-2"), new Screen(103, "Theatre-3"),
				new Screen(104, "Theatre-4"));
		when(screenDao.getScreens()).thenReturn(alreadyExistScreen);
		when(screenDao.addScreen(any(Screen.class))).thenThrow(ScreenLimitException.class);
		screenService.addScreen(screen);
	}

	@Test(expected = NullPointerException.class)
	public void addMovieToScreen_shouldThrowNullException_WhenMovieObjectIsNull() {
		movie = null;
		screen = new Screen();
		screen.setScreenId(103);
		screen.setScreenName("Theatre-3");
		screenService.addMovieToScreen(movie, screen);

	}

}
