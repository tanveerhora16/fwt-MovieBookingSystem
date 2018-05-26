package com.yash.mbs.service;

import java.util.List;

import com.yash.mbs.domain.Row;

public interface SeatingArrangementService {

	public final String CATEGORY_GOLD = "GOLD";
	public final String CATEGORY_SILVER = "SILVER";
	public final String CATEGORY_PLATINUM = "PLATINUM";
	public List<Row> createSeatingArrangementAccordingToCategory(String category, Integer numberOfRowsInCategory, Integer numberOfSeatsInFirstRow);

}





