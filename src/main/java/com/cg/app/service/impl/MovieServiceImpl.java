package com.cg.app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.app.entities.Movie;
import com.cg.app.service.MovieService;
import com.cg.app.util.FileUtils;

public class MovieServiceImpl implements MovieService {

	@Override
	public List<String> getMoviesByTheatre(String theatreId) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Set<String>> moviesByTheatre = FileUtils.oneToMany("theatreName", "movieName");
		
	     for(Map.Entry<String, Set<String>> entry: moviesByTheatre.entrySet())
         {
        	 System.out.println("\nTheatre: "+ entry.getKey());
        	 for(String val: entry.getValue())
        	 {
            	 System.out.println("Movie: "+ val);
        	 }
         }
         
		return null;
	}

	@Override
	public List<String> getMoviesByCity(String cityName) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Set<String>> theatresByCity = FileUtils.oneToMany("cityName", "theatreName");
		
	     for(Map.Entry<String, Set<String>> entry: theatresByCity.entrySet())
        {
	       	 System.out.println("\nCity: "+ entry.getKey());
	       	 
	       	 for(String val: entry.getValue())
	       	 {
	           	 System.out.println("Theatre: "+ val);
	       	 }
       	 
        }
	     
		return null;
	}

	@Override
	public List<String> getMoviesAboveRating(double thresholdRating) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> moviesToRating = FileUtils.oneToOne("movieName", "movieRating");
		 for(Map.Entry<String, String> entry: moviesToRating.entrySet())
         {
        	 System.out.println("\nMovie: "+ entry.getKey());
             System.out.println("Rating: "+ entry.getValue());
        	 
         }
		return null;
	}
	
	public static void main(String[] args) throws IOException
	{
		
		MovieService ser = new MovieServiceImpl();
		ser.getMoviesByTheatre("Hi");
		ser.getMoviesByCity("yolo");
		ser.getMoviesAboveRating(2.0);
		
	}
	
	

}
