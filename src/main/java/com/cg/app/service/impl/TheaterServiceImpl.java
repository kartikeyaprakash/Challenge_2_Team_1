package com.cg.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

	private List<Theatre> listTheatre;

	public TheaterServiceImpl(List<Theatre> listTheatre) {
		super();
		this.listTheatre = listTheatre;
	}

	@Override
	public List<Theatre> getTheaterByCity(String city) {

		List<Theatre> theatres = listTheatre.stream().filter(ta -> ta.getCity().getName().equalsIgnoreCase(city))
				.collect(Collectors.toList());

		return theatres;
	}

	@Override
	public List<Theatre> getTheaterByMovie(String movie) {

		return listTheatre.stream().filter(t -> t.getMovies().contains(new Movie(movie))).collect(Collectors.toList());
	}

	@Override
	public List<ShowTime> getShowTimeByMovieTheater(String movie, String Theater) {

		Optional<Theatre> tList = listTheatre.stream().filter(th -> th.getName().equalsIgnoreCase(Theater)).findFirst();
		if(!tList.isPresent()) 
			throw new NoSuchElementException();
		List<ShowTime> showtimeList = tList.get().getShowTime().stream().filter(m -> m.getMovie().getName().equalsIgnoreCase(movie))
				.collect(Collectors.toList());
		return showtimeList;
	}

}
