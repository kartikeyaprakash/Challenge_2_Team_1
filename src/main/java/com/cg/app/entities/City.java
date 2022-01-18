package com.cg.app.entities;

import java.util.List;
import java.util.Objects;

public class City {
	
	private String id;
	private String name;
	private String state;
	//private String location;
	private List<Theatre> theatres;
	
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Theatre> getTheatres() {
		return theatres;
	}
	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}
	
	public City(String id, String name, String state, List<Theatre> theatres) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.theatres = theatres;
	}
	
	public City() {
		super();
	}
	public City(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		City other = (City) obj;
		if(this.name.equalsIgnoreCase(other.getName()))
			return true;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "City [name=" + name + "]";
	}
	
	
	
	
	
	
	
	

}
