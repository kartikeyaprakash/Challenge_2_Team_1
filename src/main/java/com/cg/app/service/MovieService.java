package com.cg.app.service;

import java.io.IOException;
import java.util.List;

import com.cg.app.entities.Movie;

public interface MovieService {
	
	public List<String> getMoviesByTheatre(String theatreName) throws IOException;
	
	public List<String> getMoviesByCity(String cityName) throws IOException;
	
	public List<String> getMoviesAboveRating(Double thresholdRating) throws IOException;

}
