package com.yash.mbs.daoimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.yash.mbs.dao.ScreenDao;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.util.JSONUtil;



public class ScreenDaoImplTest {

	@Test
	public void add_ScreenObjectGiven_ShouldReturnOne() {
		JSONUtil jsonUtil=mock(JSONUtil.class);
		ScreenDao screenDao=new ScreenDaoImpl(jsonUtil);
		Screen screen=new Screen(101,"Screen 1");
		when(jsonUtil.writeScreenToList(screen)).thenReturn(1);
		assertEquals(1,screenDao.addScreen(screen));
	}	
}
