package com.cg.app.entities;

import java.util.List;
import java.util.Objects;

public class Theatre {
	
	private String id;
	private String name;
	private List<Movie> movies;
	private List<Screen> screens;
	private City city;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public List<Screen> getScreens() {
		return screens;
	}
	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	public Theatre(String id, String name, List<Movie> movies, List<Screen> screens, City city) {
		super();
		this.id = id;
		this.name = name;
		this.movies = movies;
		this.screens = screens;
		this.city = city;
	}
	public Theatre() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatre other = (Theatre) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", movies=" + movies + ", screens=" + screens + ", city=" + city
				+ "]";
	}
	
	
	
	

	
	
	

}
