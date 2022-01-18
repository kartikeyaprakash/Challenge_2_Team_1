package com.cg.app.entities;

import java.util.List;

public class ShowTime {
	
	private String id;
	private int showTimeStart;
	private int showTimeEnd;
	private Movie movie;
	private Screen screen;
	
	//change to map (make seat chart)
	private List<Seat> seats;

	public int getShowTimeStart() {
		return showTimeStart;
	}

	public void setShowTimeStart(int showTimeStart) {
		this.showTimeStart = showTimeStart;
	}

	public ShowTime(int showTimeStart) {
		super();
		this.showTimeStart = showTimeStart;
	}

	@Override
	public String toString() {
		return "ShowTime [showTimeStart=" + showTimeStart + "]";
	}
	

}
