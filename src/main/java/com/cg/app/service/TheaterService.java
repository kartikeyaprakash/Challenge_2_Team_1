package com.cg.app.service;
import java.util.List;

import com.cg.app.entities.ShowTime;
import com.cg.app.entities.Theatre;
public interface TheaterService {
	
	List<Theatre> getTheaterByCity(String city);
	List<Theatre> getTheaterByMovie(String movie);
	List<ShowTime> getShowTimeByMovieTheater(String movie, String Theater);
	

}
