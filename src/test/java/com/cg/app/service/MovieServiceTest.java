package com.cg.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import com.cg.app.service.impl.MovieServiceImpl;

public class MovieServiceTest {

	@BeforeAll
	public void setup() {
		MovieService movieService = new MovieServiceImpl();
		
	}

	@Test
	/*
	 * 
	 */
	public void testGetMoviesByTheatre() {
	}

	
}
