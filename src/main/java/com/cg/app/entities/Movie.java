package com.cg.app.entities;

import java.util.List;
import java.util.Objects;

public class Movie {
	
	private String id;
	private String name;
	
	//Future: enums
	private String genre;
	private double rating;
	private List<Actor> cast;
	
	
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public List<Actor> getCast() {
		return cast;
	}
	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	
	public Movie(String id, String name, String genre, double rating, List<Actor> cast) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.rating = rating;
		this.cast = cast;
	}
	public Movie() {
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
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genre=" + genre + ", rating=" + rating + ", cast=" + cast
				+ "]";
	}
	
	
	

}
