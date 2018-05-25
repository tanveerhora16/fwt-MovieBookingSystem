package com.yash.mbs.domain;

public class Movie {

	private int movieId;
	private String title;
	private String production;
	private String duration;
	
	
	public Movie(int movieId, String title, String production, String duration) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.production = production;
		this.duration = duration;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
    
	
	
	
	
}
