package com.restaurantapp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Restaurant;
import java.util.List;


@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{

	// derived query
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByCityAndType(String city, String type);
	List<Restaurant> findByCuisineAndType(String Cuisine, String type);
	
//	List<Restaurant> findByItemsItemName(String itemName);
	
	//custom query
	@Query("from Restaurant r inner join r.items it where it.itemName=?1")
	List<Restaurant> findByItemName(String itemName);
	
	@Query("from Restaurant r inner join r.items it where r.cuisine=?1 and it.category=?2")	
	List<Restaurant> findByCuisineCategory(String cuisine,String category);
	
	@Query(
			"""
		from Restaurant r inner join r.items it 
		where it.itemName=?1
		and it.price<?2
			
			""")
	List<Restaurant> findByItemNamePrice(String itemName, double price);
	
	@Query("from Restaurant r inner join r.items it where it.category=?1")
	List<Restaurant> findByCategory(String category);
	
	@Query("from Restaurant r inner join r.items it where it.itemName like %?1%")
	List<Restaurant> findBySpecialItem(String itemName);
	//derived queries
	List<Restaurant> findByItemsItemNameContains(String itemName);
	
}
