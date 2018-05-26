package com.yash.mbs.serviceimpl;

import com.yash.mbs.dao.MovieDao;
import com.yash.mbs.daoimpl.MovieDaoImpl;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.exception.EmptyException;
import com.yash.mbs.service.MovieService;


public class MovieServiceImpl implements MovieService {

	private MovieDao movieDao;

	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

 public MovieServiceImpl() {
	this.movieDao = new MovieDaoImpl();
	
}

	@Override
	public boolean addMovie(Movie movie, String screenName) {
		boolean isAdd = false;
		if (screenName == null || movie == null) {
			throw new NullPointerException("Screen name or movie can not be null.");
		}
		if (screenName.isEmpty()) {
			throw new EmptyException("Screen name can not be empty.");
		}
		isAdd = movieDao.insertMovie(movie,screenName);
		return isAdd;
	}

}
