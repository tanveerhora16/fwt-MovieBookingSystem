package com.yash.mbs.main;

import java.util.Scanner;

import com.yash.mbs.dao.ShowDao;
import com.yash.mbs.daoimpl.ShowDaoImpl;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.domain.Show;
import com.yash.mbs.service.MovieService;
import com.yash.mbs.service.ScreenService;
import com.yash.mbs.service.ShowService;
import com.yash.mbs.serviceimpl.MovieServiceImpl;
import com.yash.mbs.serviceimpl.ScreenServiceImpl;
import com.yash.mbs.serviceimpl.ShowServiceImpl;
import com.yash.mbs.util.JSONUtil;
import com.yash.mbs.util.OperatorMenuOptions;



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
		JSONUtil jsonUtil = new JSONUtil();
		String filePath = "src/main/resources/file/OperatorMenu.txt";
		OperatorMenuOptions operatorMenu = new OperatorMenuOptions();
		Scanner inputScanner = new Scanner(System.in);
		ScreenService screenService = new ScreenServiceImpl();
		MovieService movieService = new MovieServiceImpl();
		ShowDao showDao = new ShowDaoImpl(jsonUtil);
		ShowService showService = new ShowServiceImpl(showDao);
	
		String continueChoice;
		int id = 101;
		do {
			operatorMenu.getOperatorMenuOptions(filePath);
			System.out.println("Enter your choice ");
			int choice = inputScanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Your Screen name ");
				inputScanner.nextLine();
				String name = inputScanner.nextLine();
				Screen screen = new Screen(id++, name);
				screenService.addScreen(screen);
				break;
			case 2:
				Movie movie = new Movie();
				inputScanner.nextLine();
				System.out.println("Enter Screen Name ");
				String screenName = inputScanner.nextLine();
				System.out.println("Enter  Title ");
				movie.setTitle(inputScanner.nextLine());
				System.out.println("Enter Duration");
				movie.setDuration(inputScanner.nextLine());
				System.out.println("Enter Production name ");
				movie.setProduction(inputScanner.nextLine());
				System.out.println("Enter Actor Name");
				movie.setActors(inputScanner.nextLine());
				movieService.addMovie(movie, screenName);
				break;

			case 4:
				System.out.println("Enter Screen Name ");
				inputScanner.nextLine();
				String screenname = inputScanner.nextLine();
				showService.displayShows(screenname);
				System.out.println("Add the shows to the screen. Y/N to confirm");
				continueChoice = inputScanner.next();
				if (continueChoice.equalsIgnoreCase("Y")) {
					showService.addShows(screenname);
				}
				break;
			}
			System.out.println("Do you want to Continue (Y/N)");
			continueChoice = inputScanner.next();
		} while (continueChoice.equalsIgnoreCase("y"));

	}

	public void showMenuOptionsToOperator() {

	}

}
