package com.apps.mtbp.theatre.entity;

import java.io.Serializable;

public class Movie implements Serializable {

	private static final long serialVersionUID = 2974196011783533768L;

	private int movieId;	
	private String movieName;
	private String language;	
	private String genre;
	private String length;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}	

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

}
