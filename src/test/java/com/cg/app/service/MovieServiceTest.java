package com.cg.app.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.app.service.impl.MovieServiceImpl;
import com.cg.app.util.FileUtils;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

	@Mock
	FileUtils fileUtils;
	
	@InjectMocks
	MovieService movieService = new MovieServiceImpl();
	
	@BeforeEach
	public void setup(){
	    MockitoAnnotations.initMocks(this); 
	}
	
	
    @Test
    /**
     * Scenario: theatreName Exists in the csv file
     * @throws IOException
     */
	public void testGetMoviesByTheatreIfPresent() throws IOException{
		
		Set<String> movies = new HashSet<>();
		String testMovieValue = "testMovie1";
		movies.add("testMovie1");
		movies.add("testMovie2");
		String theatreNamePresent = "testTheatre1";
		Map<String, Set<String>> moviesByTheatre = new HashMap<>();
		moviesByTheatre.put(theatreNamePresent, movies);
		
		when(fileUtils.oneToMany("theatreName", "movieName")).thenReturn(moviesByTheatre);
		List<String> moviesInTheatre = movieService.getMoviesByTheatre(theatreNamePresent);
		assertEquals(moviesInTheatre.size(), movies.size());
		assertEquals(moviesInTheatre.contains(testMovieValue), movies.contains(testMovieValue));
		
	}
    
    
    @Test
    /**
     * Scenario: theatreName doesn't Exists in the csv file
     * @throws IOException
     */
	public void testGetMoviesByTheatreIfNotPresent() throws IOException{
		
		Set<String> movies = new HashSet<>();
		//String testMovieValue = "testMovie1";
		movies.add("testMovie1");
		movies.add("testMovie2");
		String theatreNamePresent = "testTheatre1";
		String theatreNameNotPresent = "testTheatre2";
		Map<String, Set<String>> moviesByTheatre = new HashMap<>();
		moviesByTheatre.put(theatreNamePresent, movies);
		
		when(fileUtils.oneToMany("theatreName", "movieName")).thenReturn(moviesByTheatre);
		List<String> moviesInTheatre = movieService.getMoviesByTheatre(theatreNameNotPresent);
		
		//can add checking for custom exceptions here
		assertEquals(moviesInTheatre.size(), 0);
		//assertEquals(moviesInTheatre.contains(testMovieValue), movies.contains(testMovieValue));
		
	}
    
    @Test
    @Disabled
    /**
     * Scenario: cityName exists in csv file
     * @throws IOException
     */
    public void testGetMoviesByCityIfPresent() throws IOException
    {
    	Set<String> movies = new HashSet<>();
		String testMovieValue = "testMovie1";
		movies.add(testMovieValue);
		movies.add("testMovie2");
		String theatreNamePresent = "testTheatre1";
		Map<String, Set<String>> moviesByTheatre = new HashMap<>();
		moviesByTheatre.put(theatreNamePresent, movies);
    	
		Set<String> theatres = new HashSet<>();
		theatres.add(theatreNamePresent);
		String cityNamePresent  = "cityNamePresent";
		Map<String, Set<String>> theatresByCity = new HashMap<>();
		theatresByCity.put(cityNamePresent, theatres);
		
		
		when(fileUtils.oneToMany("theatreName", "movieName")).thenReturn(moviesByTheatre);
		when(fileUtils.oneToMany("cityName", "theatreName")).thenReturn(theatresByCity);
		
		List<String> moviesInCity = movieService.getMoviesByCity(cityNamePresent);
		assertEquals(moviesInCity.size(), movies.size());
		assertEquals(moviesInCity.contains(testMovieValue), movies.contains(testMovieValue));
		
    }
    
    @Test
    @Disabled
    /**
     * Scenario: cityName doesnt exist in csv file
     * @throws IOException
     */
    public void testGetMoviesByCityIfNotPresent() throws IOException
    {
    	Set<String> movies = new HashSet<>();
		String testMovieValue = "testMovie1";
		movies.add(testMovieValue);
		movies.add("testMovie2");
		String theatreNamePresent = "testTheatre1";
		Map<String, Set<String>> moviesByTheatre = new HashMap<>();
		moviesByTheatre.put(theatreNamePresent, movies);
    	
		Set<String> theatres = new HashSet<>();
		theatres.add(theatreNamePresent);
		String cityNamePresent  = "cityNamePresent";
		Map<String, Set<String>> theatresByCity = new HashMap<>();
		theatresByCity.put(cityNamePresent, theatres);
		
		String cityNameNotPresent  = "cityNameNotPresent";

		
		
		when(fileUtils.oneToMany("theatreName", "movieName")).thenReturn(moviesByTheatre);
		when(fileUtils.oneToMany("cityName", "theatreName")).thenReturn(theatresByCity);
		
		List<String> moviesInCity = movieService.getMoviesByCity(cityNameNotPresent);
		
		//add checking for custom exceptions here
		assertEquals(moviesInCity.size(), 0);
		
    }
    
    @Test
    /**
     * Scenario: Check whether movies above certain rating are fetched correctly
     * @throws IOException
     */
    public void testGetMoviesAboveRating() throws IOException
    {
    	Map<String, String> moviesToRating = new HashMap<>();
    	String testMovieValue = "testMovie4";
    	moviesToRating.put("testMovie1", "3.0");
    	moviesToRating.put("testMovie2", "4.0");
    	moviesToRating.put("testMovie3", "5.0");
    	moviesToRating.put(testMovieValue, "6.0");
    	
    	when(fileUtils.oneToOne("movieName", "movieRating")).thenReturn(moviesToRating);
    	List<String> moviesAboveRating = movieService.getMoviesAboveRating(3.5);
    	assertEquals(moviesAboveRating.size(), 3);    
    	assertTrue(moviesAboveRating.contains(testMovieValue));
    	
    }



	
}
