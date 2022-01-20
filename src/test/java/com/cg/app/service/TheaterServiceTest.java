package com.cg.app.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.cg.app.entities.City;
import com.cg.app.entities.Movie;
import com.cg.app.entities.ShowTime;
import com.cg.app.entities.Theatre;
import com.cg.app.service.impl.TheaterServiceImpl;
import com.cg.app.util.TheaterUtil;

public class TheaterServiceTest {

	private static TheaterService service;

	@BeforeAll
	public static void setup() {

		List<Theatre> theatreList = new ArrayList<>();
		
		Theatre theatre1 = new Theatre("theatre1");
		Movie movie1 = new Movie("movie1");
		Movie movie2 = new Movie("movie2");
		City city1 = new City("city1");
		ShowTime st1 = new ShowTime("4:30pm");
		st1.setMovie(movie1);
		ShowTime st2 = new ShowTime("6:30pm");
		st2.setMovie(movie2);
		theatre1.setCity(city1);
		theatre1.getMovies().add(movie1);
		theatre1.getMovies().add(movie2);
		theatre1.getShowTime().add(st1);
		theatre1.getShowTime().add(st2);
		theatreList.add(theatre1);
		
		Theatre theatre2 = new Theatre("theatre2");
		Movie movie3 = new Movie("movie1");
		Movie movie4 = new Movie("movie2");
		City city2 = new City("city1");
		ShowTime st3 = new ShowTime("4:30pm");
		st1.setMovie(movie1);
		theatre2.setCity(city2);
		theatre2.getMovies().add(movie4);
		theatre2.getMovies().add(movie3);
		theatre2.getShowTime().add(st1);
		theatreList.add(theatre2);
		
		
		
		service = new TheaterServiceImpl(theatreList);
		

	}

	@Test
	public void getTheaterByCityTest() {
		List<Theatre> list = service.getTheaterByCity("city1");
		
		assertTrue(list.stream()
				.allMatch(t -> t.getCity().getName().equalsIgnoreCase("city1")) == true,
				() -> "All city must be equal");
		
		assertFalse(list.stream()
				.allMatch(t -> t.getCity().getName().equalsIgnoreCase("xyz")) == true,
				() -> "Any city must not be equal to xyz");
		assertEquals(2, list.size());
		
		list = service.getTheaterByCity("city");
		
		assertEquals( 0, list.size());
		
		list = service.getTheaterByCity("");
		assertEquals( 0, list.size());
		
		list = service.getTheaterByCity(null);
		assertEquals( 0, list.size());
		
	}

	@Test
	public void getTheaterByMovieTest() {
		List<Theatre> list = service.getTheaterByMovie("movie1");
		
		assertTrue(list.stream()
				.allMatch(t -> t.getMovies().contains(new Movie("movie1"))) == true,
				() -> "All theater must contain movie1");
		assertFalse(list.stream()
				.allMatch(t -> t.getMovies().contains(new Movie("movie5"))) == true,
				() -> "All theater must not contain movie5");
		
		list = service.getTheaterByMovie("xyz");
		assertEquals( 0, list.size());
		
		list = service.getTheaterByMovie("");
		assertEquals( 0, list.size());
		
		list = service.getTheaterByMovie(null);
		assertEquals( 0, list.size());
		
	}

	@Test
	public void getShowTimeByMovieTheater() {
		
		List<ShowTime> list = service.getShowTimeByMovieTheater("movie1", "theatre1");
		assertTrue(list.stream()
				.allMatch(t -> t.getMovie().getName().equals("movie1") && t.getShowTime().equalsIgnoreCase("4:30pm")) == true,
				() -> "Show time must equal");
		assertEquals(1, list.size());
		
		assertThrows(NoSuchElementException.class, () -> {
			service.getShowTimeByMovieTheater("movie", "theatre");
		    });
		assertThrows(NoSuchElementException.class, () -> {
			service.getShowTimeByMovieTheater("", "");
		    });
		
	}
}
