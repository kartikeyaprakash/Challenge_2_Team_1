package com.cg.app.entities;

import java.util.Objects;

public class User {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private boolean isLoggedIn;
	private boolean isVaccinated;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public boolean isVaccinated() {
		return isVaccinated;
	}
	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}
	
	
	public User(String id, String firstName, String lastName, String email, String password, String address,
			boolean isLoggedIn, boolean isVaccinated) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.isLoggedIn = isLoggedIn;
		this.isVaccinated = isVaccinated;
	}
	
	
	public User() {
		super();
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", isLoggedIn=" + isLoggedIn + ", isVaccinated="
				+ isVaccinated + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
