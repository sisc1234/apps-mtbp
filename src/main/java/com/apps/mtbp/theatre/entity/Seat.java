package com.apps.mtbp.theatre.entity;

import java.io.Serializable;

public class Seat implements Serializable {

	private static final long serialVersionUID = -2066974366328882925L;
	private int seatId;
	private String tier;
	private String price;
	private String status;

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

}
