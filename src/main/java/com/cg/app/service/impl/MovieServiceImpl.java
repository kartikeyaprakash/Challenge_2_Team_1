package com.cg.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cg.app.entities.Movie;
import com.cg.app.service.MovieService;
import com.cg.app.util.FileUtils;

public class MovieServiceImpl implements MovieService {

	FileUtils fileUtils = new FileUtils();
	
	@Override
	public List<String> getMoviesByTheatre(String theatreName) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Set<String>> moviesByTheatre = fileUtils.oneToMany("theatreName", "movieName");
		
		if(!moviesByTheatre.containsKey(theatreName))
		{
			//returns empty array(theatreName not in csv), can add custom exceptions later
			return new ArrayList<>();
		}
		
		else 
		{
			return new ArrayList<>(moviesByTheatre.get(theatreName));
		}
		
	}

	@Override
	public List<String> getMoviesByCity(String cityName) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, Set<String>> theatresByCity = fileUtils.oneToMany("cityName", "theatreName");
		Map<String, Set<String>> moviesByTheatre = fileUtils.oneToMany("theatreName", "movieName");
		
		Set<String> allMoviesInCity = new HashSet<>();
		
		if(!theatresByCity.containsKey(cityName))
		{
			//cityName not in csv, can add custom exceptions here later on 
			return new ArrayList<>();
		}
		else
		{
			for(String theatre: theatresByCity.get(cityName))
			{
				allMoviesInCity.addAll(moviesByTheatre.get(theatre));
			}
			
			return new ArrayList<>(allMoviesInCity);
		}
		
	}

	@Override
	public List<String> getMoviesAboveRating(Double thresholdRating) throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> moviesToRating = fileUtils.oneToOne("movieName", "movieRating");
		List<String> movieAboveThresholdRating = new ArrayList<>();
		 for(Map.Entry<String, String> entry: moviesToRating.entrySet())
         {
			 if(Double.parseDouble(entry.getValue())>thresholdRating)
			 {
				 movieAboveThresholdRating.add(entry.getKey());
			 }
        	 
         }
		return movieAboveThresholdRating;
	}
	

	
	

}
