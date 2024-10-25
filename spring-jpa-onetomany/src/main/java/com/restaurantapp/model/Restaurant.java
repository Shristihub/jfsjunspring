package com.restaurantapp.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Restaurant {

	@Column(length=30)
	private String restaurantName;
	@Id
	@GeneratedValue(generator = "resta_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="resta_gen",sequenceName = "resta_seq", initialValue = 1,allocationSize = 1)
	private Integer restaurantId;
	@Column(length=15)
	private String cuisine; //Indian, Italian,Mexican
	@Column(length=10)
	private String type; // veg, nonveg
	@Column(length=20)
	private String city;
	// one restaurant having many items
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	// to add the foeign key to items table
	// to remove the junction table add @JoinColumn annotation
	@JoinColumn(name = "restaurant_id") // this is the foreign key in 
	Set<Item> items;
	
	public Restaurant(String restaurantName, String cuisine, String type, String city,Set<Item> items) {
		super();
		this.restaurantName = restaurantName;
		this.cuisine = cuisine;
		this.type = type;
		this.city = city;
		this.items = items;
				
	}
	
	
	
}







