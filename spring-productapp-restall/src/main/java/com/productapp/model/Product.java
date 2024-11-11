package com.productapp.model;

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
	@Id // for primary key
	@GeneratedValue(generator = "product_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1)
	private int productId;
	private double price;
	private double ratings;
	@OneToOne
	private Features features;
	@ManyToOne
	private Brand brand;
	@OneToMany
	private List<Offers> offers;
	@ManyToMany
	@JsonIgnore
	private List<Category> categories;
	@ElementCollection
	private List<String> paymentType; //COD,UPI,CARD
	@ElementCollection
	private List<String> deliveryType; //amazon delivered,standard,prime
	
}
