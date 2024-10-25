package com.restaurantapp.service;

import java.util.List;

import com.restaurantapp.exception.RestaurantNotFoundException;
import com.restaurantapp.model.Restaurant;


public interface IRestaurantService {
	// inbuilt
	void addRestaurant(Restaurant restaurant);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	Restaurant getById(int restaurantId) throws RestaurantNotFoundException;
	List<Restaurant> getAll();
	
	
	// derived
	List<Restaurant> getByCity(String city);
	List<Restaurant> getByCityAndType(String city,String type);
	List<Restaurant> getByCuisineandType(String cuisine, String type);
	List<Restaurant> getByItemName(String itemName); 
	List<Restaurant> getByCuisineCategory(String cuisine,String category);
	List<Restaurant> getByItemNamePrice(String itemName, double price);
	List<Restaurant> getByCategory(String category);
	List<Restaurant> getBySpecialItem(String specialitem);
	
}
