package com.yash.mbs.main;

import com.yash.mbs.literals.MovieBookingMenuOptions;

/**
 * 
 * @author tanveer.hora
 * @purpose This is the class from where all the operations of movie booking
 *          system is managed
 * 
 */
public class MovieBookingSystem {

	public void showMenu() {
		System.out.println("*************************Welcome To Movie Booking System*************************");
		showMenuOptionsToOperator();
	}

	public void showMenuOptionsToOperator() {

		System.out.println(MovieBookingMenuOptions.MBS_OPTIONS);
		System.out.println(MovieBookingMenuOptions.ADDING_SCREEN);
		System.out.println(MovieBookingMenuOptions.ADDING_MOVIE_TO_SCREEN);
		System.out.println(MovieBookingMenuOptions.DESIGN_SEATING_ARRANGEMENT_TO_SCREEN);
		System.out.println(MovieBookingMenuOptions.ADDING_SHOWS_FOR_MOVIE);
		System.out.println(MovieBookingMenuOptions.BOOK_TICKET);
		System.out.println(MovieBookingMenuOptions.CANCEL_BOOKING);
		System.out.println(MovieBookingMenuOptions.SHOW_AVAILABILITY);
		System.out.println(MovieBookingMenuOptions.REPORTS);
		System.out.println(MovieBookingMenuOptions.ENTER_YOUR_CHOICE);
	}

}
