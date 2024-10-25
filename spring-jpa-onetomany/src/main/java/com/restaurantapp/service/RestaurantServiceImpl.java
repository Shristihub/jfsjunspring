package com.restaurantapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantapp.exception.RestaurantNotFoundException;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.respository.IRestaurantRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	@Autowired
	private IRestaurantRepository restaurantRepository;
	

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}

	@Override
	public Restaurant getById(int restaurantId) throws RestaurantNotFoundException {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(()-> new RestaurantNotFoundException("invalid id"));
	}

	@Override
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> getByCity(String city) {
		List<Restaurant> restaurants = restaurantRepository.findByCity(city);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this city found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getByCityAndType(String city, String type) {
		List<Restaurant> restaurants = restaurantRepository.findByCityAndType(city,type);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this city found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getByCuisineandType(String cuisine, String type) {
		List<Restaurant> restaurants = restaurantRepository.findByCuisineAndType(cuisine,type);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this cuisine found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getByItemName(String itemName) {
		List<Restaurant> restaurants = restaurantRepository.findByItemName(itemName);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this item found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getByCuisineCategory(String cuisine, String category) {
		List<Restaurant> restaurants = restaurantRepository.findByCuisineCategory(cuisine, category);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this cuisine cat found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getByItemNamePrice(String itemName, double price) {
		List<Restaurant> restaurants = restaurantRepository.findByItemNamePrice(itemName, price);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this itemname found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getByCategory(String category) {
		List<Restaurant> restaurants = restaurantRepository.findByCategory(category);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this category found");
		return restaurants;
	}

	@Override
	public List<Restaurant> getBySpecialItem(String specialitem) {
		List<Restaurant> restaurants = restaurantRepository.findBySpecialItem(specialitem);
//				.findByItemsItemNameContains(specialitem);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("no rest for this city found");
		return restaurants;
	}

}
