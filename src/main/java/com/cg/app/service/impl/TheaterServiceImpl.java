package com.cg.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.cg.app.entities.City;
import com.cg.app.entities.Movie;
import com.cg.app.entities.ShowTime;
import com.cg.app.entities.Theatre;
import com.cg.app.service.TheaterService;

public class TheaterServiceImpl implements TheaterService {
	
	static List<Theatre> listTheatre = new ArrayList<>();
	
	private static void csvUtil() throws IOException {
		BufferedReader reader = Files.newBufferedReader(Paths.get("input1.csv"));
	   	// BufferedReader reader = new BufferedReader(new InputStreamReader (new FileInputStream("input.csv"),Charset.forName("windows-1250")));
	        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("cityName", "theatreName", "movieName", "actors", "movieRating","showTime").withIgnoreHeaderCase().withTrim());
	        
	        for (CSVRecord csvRecord: csvParser) {
	        	String city = csvRecord.get("cityName");
	        	String theater = csvRecord.get("theatreName");
	        	String movie = csvRecord.get("movieName");
	        	String showTime = csvRecord.get("showTime");
	        	
	        	Theatre newTheatre = new Theatre(theater);
	        	boolean check = listTheatre.stream().anyMatch(t -> t.equals(newTheatre));
	        	if(!check) {
	        		newTheatre.setCity(new City(city));
	        		List<Movie> moviesList = newTheatre.getMovies();
	        		moviesList.add(new Movie(movie));
	        		List<ShowTime> showList = newTheatre.getShowTime();
	        		showList.add(new ShowTime(5));
	        		listTheatre.add(newTheatre);
	        		
	        	}
	        	else {
	        		Optional<Theatre> opt = listTheatre.stream().filter(t -> t.equals(newTheatre)).findFirst();
	        		Theatre t = opt.get();
	        		if(!t.getCity().getName().equalsIgnoreCase(city))
	        			t.setCity(new City(city));
	        		List<Movie> moviesList = t.getMovies();
	        		if(moviesList.contains(new Movie(movie)))
	        		moviesList.add(new Movie(movie));
	        		List<ShowTime> showList = t.getShowTime();
	        		showList.add(new ShowTime(5));
	        		
	        	}
	        }
	        try {
//				for(Theatre t : listTheatre) {
//					System.out.println(t.toString());
//				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error");
				e.printStackTrace();
			}
		
	}

	@Override
	public List<Theatre> getTheaterByCity(String city) {
		// TODO Auto-generated method stub
		List<Theatre> t = listTheatre.stream().filter(ta -> ta.getCity().getName().equalsIgnoreCase(city)).collect(Collectors.toList());
		System.out.println(t.size() + " size");
		return t;
	}

	@Override
	public List<Theatre> getTheaterByMovie(String movie) {
		// TODO Auto-generated method stub
		return listTheatre.stream().filter(t -> t.getMovies().contains(new Movie(movie))).collect(Collectors.toList());
	}

	@Override
	public List<Theatre> getShowTimeByCityTheater(String city, String Theater) {
		// TODO Auto-generated method stub
		return listTheatre.stream().filter(t -> t.getCity().getName().equalsIgnoreCase(city) && t.getName().equalsIgnoreCase(Theater)).collect(Collectors.toList());
	}
	public static void main(String[] args) throws IOException {
		csvUtil();
		TheaterService ts = new TheaterServiceImpl();
		//ts.getTheaterByMovie("m3").forEach(t -> System.out.println(t));
		
	}

}
