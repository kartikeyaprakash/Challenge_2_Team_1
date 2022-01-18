package com.cg.app.entities;

import java.util.List;

public class ShowTime {
	
	private String id;
	//private int showTimeStart;
	private String showTime;
	private int showTimeEnd;
	private Movie movie;
	private Screen screen;
	
	//change to map (make seat chart)
	private List<Seat> seats;
	
//	public int getShowTimeStart() {
//		return showTimeStart;
//	}
//
//	public void setShowTimeStart(int showTimeStart) {
//		this.showTimeStart = showTimeStart;
//	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ShowTime(String showTime) {
		super();
		this.showTime = showTime;
	}

	@Override
	public String toString() {
		return "ShowTime [showTime=" + showTime + ", movie=" + movie + "]";
	}

	

	

	

}
