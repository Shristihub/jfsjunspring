package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.Cuisine;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.Type;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringJpaOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetomanyApplication.class, args);
	}

	@Autowired
	private IRestaurantService restaurantService;
	
	@Override
	public void run(String... args) throws Exception {
		Item item1 = new Item("Onion Dosa","BREAKFAST",190);
		Item item2 = new Item("garlic bread","STARTERS",150);
		Item item3 = new Item("Pasta","LUNCH",30);
		
		Set<Item> itemsSet = new HashSet<>(Arrays.asList(item1,item2,item3));
		Restaurant restaurant = new Restaurant("Hotel Satvam", Cuisine.NORTH.getCuisine(),
				Type.VEG.toString(), "Bangalore",itemsSet);
		restaurantService.addRestaurant(restaurant);
		
		restaurantService.getAll().forEach(System.out::println);
		System.out.println();
//		restaurantService.getByCityAndType("Bangalore", "VEG").forEach(
//				restaurant1->{
//					System.out.println("Name "+restaurant1.getRestaurantName());
//					System.out.println("Items"+restaurant1.getCuisine());
//					Set<Item> items = restaurant1.getItems();
//					items.forEach(item->{
//						System.out.println("ItemName "+item.getItemName());
//						System.out.println("Price "+item.getPrice());
//					});
//				});
		
		System.out.println();
		restaurantService.getBySpecialItem("Dosa").forEach(
				restaurant1->{
					System.out.println("Name "+restaurant1.getRestaurantName());
					System.out.println("Cuisine"+restaurant1.getCuisine());
					Set<Item> items = restaurant1.getItems();
					items.stream()
					 .filter(item->item.getItemName().contains("Dosa"))
					 .forEach(item->{
						 System.out.println("Name "+item.getItemName()+" price "+item.getPrice());
					 });
				});
		
		
	}

}
