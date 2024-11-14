package com.productapp.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Product {
 
	private String productName;
	@Id
	@GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1)
	private Integer productId;
	private LocalDate mfgDate;
	
	private double price;
	// use cascade
	@OneToOne
	// use joincolumn to change column name
	private Features features;
	//use cascade,fetch
	// use join column to remove the junction(third) table
	@OneToMany
	private List<Offers> offers;
	
	// use joincolumn
	@ManyToOne
	private Brand brand;
	
	// use fetch
	@ManyToMany
//	@JsonIgnore
	// use jointable
	private List<Category> categories;
	
	@ElementCollection
	//use collectiontable
	private List<String> deliveryTypes;
	
	@ElementCollection
	private List<String> paymentMode;

	public Product(String productName, double price, Features features, List<Offers> offers, Brand brand,
			List<Category> categories, List<String> deliveryTypes, List<String> paymentMode) {
		super();
		this.productName = productName;
		this.price = price;
		this.features = features;
		this.offers = offers;
		this.brand = brand;
		this.categories = categories;
		this.deliveryTypes = deliveryTypes;
		this.paymentMode = paymentMode;
	}
	
	
	
}
