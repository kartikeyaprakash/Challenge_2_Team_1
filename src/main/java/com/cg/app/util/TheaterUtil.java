package com.cg.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.cg.app.entities.City;
import com.cg.app.entities.Movie;
import com.cg.app.entities.ShowTime;
import com.cg.app.entities.Theatre;

public class TheaterUtil {
	
	public List<Theatre> csvUtil() throws IOException {
		BufferedReader reader = Files.newBufferedReader(Paths.get("input1.csv"));

		CSVParser csvParser = new CSVParser(reader,
				CSVFormat.DEFAULT
						.withHeader("cityName", "theatreName", "movieName", "actors", "movieRating", "showTime")
						.withIgnoreHeaderCase().withTrim());
		List<Theatre> listTheatre = new ArrayList<>();
		for (CSVRecord csvRecord : csvParser) {
			String city = csvRecord.get("cityName");
			String theater = csvRecord.get("theatreName");
			String movie = csvRecord.get("movieName");
			String showTime = csvRecord.get("showTime");

			Theatre newTheatre = new Theatre(theater);
			boolean check = listTheatre.stream().anyMatch(t -> t.equals(newTheatre));
			if (!check) {
				newTheatre.setCity(new City(city));
				List<Movie> moviesList = newTheatre.getMovies();
				moviesList.add(new Movie(movie));
				List<ShowTime> showList = newTheatre.getShowTime();
				ShowTime time = new ShowTime(showTime);
				time.setMovie(new Movie(movie));
				showList.add(time);
				listTheatre.add(newTheatre);

			} else {
				Optional<Theatre> opt = listTheatre.stream().filter(t -> t.equals(newTheatre)).findFirst();
				Theatre t = opt.get();
				if (!t.getCity().getName().equalsIgnoreCase(city))
					t.setCity(new City(city));
				List<Movie> moviesList = t.getMovies();
				if (!moviesList.contains(new Movie(movie)))
					moviesList.add(new Movie(movie));
				List<ShowTime> showList = t.getShowTime();
				ShowTime time = new ShowTime(showTime);
				time.setMovie(new Movie(movie));
				showList.add(time);

			}
		}
		try {
			for (Theatre t : listTheatre) {
				System.out.println(t.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		return listTheatre;
	}
}
