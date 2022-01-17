package com.cg.app.service;

import java.util.List;

import com.cg.app.entities.Movie;

public interface MovieService {
	
	public List<Movie> getMoviesByTheatre(String theatreId);
	
	public List<Movie> getMoviesByCity(String cityName);
	
	public List<Movie> getMoviesAboveRating(double thresholdRating);

}
