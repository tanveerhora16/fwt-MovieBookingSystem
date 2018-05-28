package com.yash.mbs.serviceimpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.yash.mbs.dao.ShowDao;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.service.ShowService;



public class ShowServiceImplTest {

	private ShowDao showDao = mock(ShowDao.class);
	private ShowService showService = new ShowServiceImpl(showDao);
	
	@Test(expected = NullPointerException.class)
	public void displayPossibleShows_ScreenNameIsNull_ThrowNullFieldException() {
		showService.displayShows(null);
	}

	@Test
	public void getScreen_ScreenNameGiven_ShouldReturnTrueIfAvailable() {

		String screenName = "screen 1";
		Screen screen = new Screen(101, "screen 1");
		when(showDao.getScreen(anyString())).thenReturn(screen);
		boolean isAvailable = showService.checkScreenAvailable(screenName);
		assertTrue(isAvailable);
	}

	@Test
	public void addShows_ScreenNameGiven_ShouldReturnTrueIfShowsAdded() {
		String screenName = "screen 1";
		when(showDao.addShows(anyString())).thenReturn(true);
		boolean isShowsAdded = showService.addShows(screenName);
		assertTrue(isShowsAdded);
	}


}
