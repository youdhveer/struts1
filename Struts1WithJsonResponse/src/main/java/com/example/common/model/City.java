package com.example.common.model;

public class City {

	private long countryId;
	private long stateId;
	private long cityId;
	private String cityName;
	
	public City(){
		
	}
	public City(long countryId, long stateId, long cityId, String cityName) {
		super();
		this.countryId = countryId;
		this.stateId = stateId;
		this.cityId = cityId;
		this.cityName = cityName;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
