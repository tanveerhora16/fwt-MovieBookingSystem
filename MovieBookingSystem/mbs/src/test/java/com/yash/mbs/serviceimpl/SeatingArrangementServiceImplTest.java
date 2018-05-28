package com.yash.mbs.serviceimpl;

import org.junit.Before;
import org.junit.Test;

import com.yash.mbs.exception.FieldLimitExceededException;
import com.yash.mbs.service.SeatingArrangementService;

public class SeatingArrangementServiceImplTest {

	private SeatingArrangementService seatingArrangementService;

	@Before
	public void setUp() throws Exception {
		this.seatingArrangementService = new SeatingArrangementServiceImpl();
	}

	@Test(expected = NullPointerException.class)
	public void createSeatingArrangementAccordingToCategory_shouldThrowNullPointerException_WhenCategoryRowsSeatsAreNull() {
		String category = null;
		Integer numberOfRowsInCategory = null;
		Integer numberOfSeatsInFirstRow = null;
		seatingArrangementService.createSeatingArrangementAccordingToCategory(category, numberOfRowsInCategory,
				numberOfSeatsInFirstRow);
	}

	@Test(expected = FieldLimitExceededException.class)
	public void createSeatingArrangementAccordingToCategory_shouldThrowFieldLimitExceededEception_whenRowCountIsGreaterThanFifteen() {
		String category = seatingArrangementService.CATEGORY_GOLD;
		Integer numberOfRowsInCategory = 16;
		Integer numberOfSeatsInFirstRow = 25;
		seatingArrangementService.createSeatingArrangementAccordingToCategory(category, numberOfRowsInCategory,
				numberOfSeatsInFirstRow);
	}

	@Test(expected = FieldLimitExceededException.class)
	public void createSeatingArrangementAccordingToCategory_shouldThrowFieldLimitExceededEception_WhenNumberOfSeatsInFirstERowIsGreatreThanTwentyFive() {
		String category = seatingArrangementService.CATEGORY_GOLD;
		Integer numberOfRowsInCategory = 9;
		Integer numberOfSeatsInFirstRow = 26;
		seatingArrangementService.createSeatingArrangementAccordingToCategory(category, numberOfRowsInCategory,
				numberOfSeatsInFirstRow);
	}
	

	@Test(expected = NullPointerException.class)
	public void createSeatingArrangementAccordingToCategory_shouldThrowFieldLimitExceededEception_WhenNumberOfSeatsInFirstERowIsGreatreThanTwenty() {
		String category = seatingArrangementService.CATEGORY_GOLD;
		Integer numberOfRowsInCategory = 9;
		Integer numberOfSeatsInFirstRow = 21;
		seatingArrangementService.createSeatingArrangementAccordingToCategory(category, numberOfRowsInCategory,
				numberOfSeatsInFirstRow);
	}
	
	
}
