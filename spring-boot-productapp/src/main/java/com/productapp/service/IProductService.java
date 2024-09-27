package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {

	List<Product> getAll();
	List<Product> getByBrand(String brand);
	List<Product> getByCategory(String category);
	List<Product> getByLesserPrice(double price);
	Product getById(int productId); // returns one product
	List<String> getProductNames();
}
