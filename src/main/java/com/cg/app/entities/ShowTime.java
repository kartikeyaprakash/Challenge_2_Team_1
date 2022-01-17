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

}
