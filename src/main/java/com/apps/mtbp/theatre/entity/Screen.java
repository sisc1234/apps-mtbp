package com.apps.mtbp.theatre.entity;

import java.io.Serializable;
import java.util.List;

public class Screen implements Serializable {

	private static final long serialVersionUID = 7985667723965567006L;

	private int screenId;
	private String screenName;
	private List<Tier> tiers;
	private List<Seat> seats;	
}
