package com.restaurantapp.model;

public enum Cuisine {

	SOUTH("SOUTH INDIAN"),
	NORTH("NORTH INDIAN"),
	ITALIAN("ITALIAN"),
	MEXICAN("MEXICAN");
	
	private String cuisineType;

	private Cuisine(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	
	public String getCuisine() {
		return cuisineType;
	}
}
