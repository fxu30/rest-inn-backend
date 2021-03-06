package com.example.restInn.entity;

public class Location {
	private String street;
	private String city;
	private String province;
	private String country;
	
	// Constructors
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(String street, String city, String province, String country) {
		super();
		this.street = street;
		this.city = city;
		this.province = province;
		this.country = country;
	}
	// Getter,Setter
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
}
