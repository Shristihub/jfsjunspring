package com.restaurantapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Item {
	@Column(length=20)
	private String itemName;
	@Id
	@GeneratedValue(generator = "item_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="item_gen",sequenceName = "item_seq", initialValue = 10,allocationSize = 1)
	private Integer itemId;
	@Column(length=20)
	private String category; // breakfast,lunch, dessert, maincourse,starter
	@Column(name="cost")
	private double price;
	public Item(String itemName, String category, double price) {
		super();
		this.itemName = itemName;
		this.category = category;
		this.price = price;
	}
	

}