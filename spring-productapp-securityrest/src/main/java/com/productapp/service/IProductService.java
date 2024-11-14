package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {


	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	Product getById(int productId);
	List<Product> getAll();
	List<Product> getByCategoryLessPrice(String category,double price);
	List<Product> getByCatBrand(String category,String brand);
	List<Product> getByNameContainingOffers(String productChoice, String offers);
	List<Product> getByBrandOffers(String brand,String offers);
	List<Product> getByNameContainingMfgAfter(String name,String dateafter);
	List<Product> getByNameContainingDelivery(String name,String delivery);//query
	List<Product> getByNameContainingPayment(String name,String paymenttype);//query
	List<Product> getByNameContainingBrand(String name,String brand);
	
	long getCountByCategory(String category);
	List<Product> getByColor(String color);
	
}
