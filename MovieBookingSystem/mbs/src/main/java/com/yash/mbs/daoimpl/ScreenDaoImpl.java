package com.yash.mbs.daoimpl;

import java.util.List;

import com.yash.mbs.dao.ScreenDao;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.util.JSONUtil;

public class ScreenDaoImpl implements ScreenDao {
	
	private JSONUtil jsonUtil;
	
	

	public ScreenDaoImpl(JSONUtil jsonUtil) {
		this.jsonUtil = jsonUtil;
	}

	public ScreenDaoImpl(){
		jsonUtil=new JSONUtil();
	}
	
	@Override
	public int addScreen(Screen screen) {
	jsonUtil.writeScreenToList(screen);
		return 1;
	}

	@Override
	public List<Screen> getScreens() {
		List<Screen> screenList=jsonUtil.readListOfScreen();
		return screenList;
	}

}
