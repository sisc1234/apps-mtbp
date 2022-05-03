package com.apps.mtbp.theatre.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Theater implements Serializable {

	private static final long serialVersionUID = 1668817786352658495L;
	private String theaterId;
	private String theaterName;
	private Set<Screen> screens;
	private List<Show> shows;

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Set<Screen> getScreens() {
		return screens;
	}

	public void setScreens(Set<Screen> screens) {
		this.screens = screens;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

}
