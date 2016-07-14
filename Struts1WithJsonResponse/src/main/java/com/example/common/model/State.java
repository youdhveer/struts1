package com.example.common.model;

public class State {

	private long stateId;
	private long countryId;
	
	private String name;
	
	public State(){
		
	}
	public State(long countryId,long stateId, String name) {
		super();
		this.countryId=countryId;
		this.stateId = stateId;
		this.name = name;
	}
	
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	
	
}
