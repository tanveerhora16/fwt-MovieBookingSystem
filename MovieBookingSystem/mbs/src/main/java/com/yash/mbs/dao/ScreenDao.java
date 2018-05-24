package com.yash.mbs.dao;

import java.util.List;

import com.yash.mbs.domain.Screen;

public interface ScreenDao {

	int addScreen(Screen screen);

	List<Screen> list();

}
