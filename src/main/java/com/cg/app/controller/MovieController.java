package com.cg.app.controller;

import java.io.IOException;
import java.util.List;

import com.cg.app.service.MovieService;
import com.cg.app.service.impl.MovieServiceImpl;

public class MovieController {
	
	MovieService movieService = new MovieServiceImpl();
	
	public List<String> getMoviesByTheatre(String theatreName) throws IOException
	{
		return movieService.getMoviesByTheatre(theatreName);
	}
	
	public List<String> getMoviesByCity(String cityName) throws IOException
	{
		return movieService.getMoviesByCity(cityName);
	}
	
	public List<String> getMoviesAboveRating(Double rating) throws IOException
	{
		return movieService.getMoviesAboveRating(rating);	
	}
	
	public static void main(String[] args) throws IOException
	{
		
		MovieController con = new MovieController();
		System.out.println(con.getMoviesByTheatre("t1"));
		System.out.println(con.getMoviesByCity("c2"));
		System.out.println(con.getMoviesAboveRating(5.0));
		
	}

}
