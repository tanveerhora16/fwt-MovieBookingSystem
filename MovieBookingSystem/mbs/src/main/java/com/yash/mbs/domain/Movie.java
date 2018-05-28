package com.yash.mbs.domain;

public class Movie {

	private int movieId;
	private String title;
	private String production;
	private String duration;
	private String actors;

	
	public Movie(int movieId, String title, String production, String duration, String actors) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.production = production;
		this.duration = duration;
		this.actors = actors;
	}
	
	public Movie(){
		
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
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
