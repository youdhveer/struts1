package com.example.common.model;

public class Country {

	private long id;
	private String countryName;
	public Country(){}
	
	public Country(long id, String countryName) {
		super();
		this.id = id;
		this.countryName = countryName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
