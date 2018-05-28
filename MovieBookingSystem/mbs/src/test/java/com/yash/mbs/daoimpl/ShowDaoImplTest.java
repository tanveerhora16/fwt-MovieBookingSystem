package com.yash.mbs.daoimpl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.dao.ShowDao;
import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.util.JSONUtil;



public class ShowDaoImplTest {

	private ShowDao showDAO=null;
	private JSONUtil jsonUtil=null;
	
	@Before()
	public void setUp() {
			jsonUtil = new JSONUtil();
			showDAO = new ShowDaoImpl(jsonUtil);
	}
	
	@Test(expected=NullPointerException.class)
	public void addShows_ScreenNameNull_ThrowNullFieldException() {
		String screenName=null;
		showDAO.addShows(screenName);
	}
	
	@Test(expected=EmptyException.class)
	public void addShows_ScreenNameEmpty_ThrowEmptyFieldException() {
		String screenName="";
		showDAO.addShows(screenName);
	}
	
	@Test
	public void addShows_ScreenNameIsCorrect_ShouldReturnTrueIfShowAdded() {
		String screenName="screen 1";
		assertTrue(showDAO.addShows(screenName));
	}
	
}
