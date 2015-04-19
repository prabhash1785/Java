package com.prabhash.java.beans;

public class SuperAddress {
	
	private String continent;
	
	public SuperAddress() {
		this("North America");
	}
	
	public SuperAddress(String continent) {
		this.continent = continent;
	}
	
	public String getContinent() {
		return this.continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}

}
