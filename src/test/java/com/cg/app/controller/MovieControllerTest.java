package com.cg.app.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.app.service.MovieService;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {
	
	@Mock
	MovieService movieService;
	
	@InjectMocks
	MovieController movieController;
	
	@Mock
	List<String> testMovies;
	
	@BeforeEach
	public  void  setup(){
	    MockitoAnnotations.initMocks(this); 
	}

	
	@Test
	
	/**
	 * Scenario: checks whether service method is called from controller classes
	 * 
	 * @throws IOException
	 */
	public void testGetMoviesByTheatre() throws IOException
	{
		String theatreName = "testTheatreName";
		
		when(movieService.getMoviesByTheatre(theatreName)).thenReturn(testMovies);
		List<String> actual = movieController.getMoviesByTheatre(theatreName);
		verify(movieService).getMoviesByTheatre(theatreName);
		assertEquals(actual.size(), testMovies.size());
		assertEquals(actual, testMovies);
	}
	
	@Test
	
	/**
	 * Scenario: checks whether service method is called from controller classes
	 * @throws IOException
	 */
	public void testGetMoviesByCity() throws IOException
	{
		String cityName = "testCityName";
		
		when(movieService.getMoviesByCity(cityName)).thenReturn(testMovies);
		List<String> actual = movieController.getMoviesByCity(cityName);
		verify(movieService).getMoviesByCity(cityName);
		assertEquals(actual.size(), testMovies.size());
		assertEquals(actual, testMovies);

	}
	
	@Test
	
	/**
	 * Scenario: checks whether service method is called from controller classes
	 * @throws IOException
	 */
	public void testGetMoviesAboveRating() throws IOException
	{
		Double rating = 5.0;
		
		when(movieService.getMoviesAboveRating(rating)).thenReturn(testMovies);
		List<String> actual = movieController.getMoviesAboveRating(rating);
		verify(movieService).getMoviesAboveRating(rating);
		assertEquals(actual.size(), testMovies.size());
		assertEquals(actual, testMovies);
	}


}
