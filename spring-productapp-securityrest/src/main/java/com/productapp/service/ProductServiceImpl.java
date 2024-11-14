package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public class ProductServiceImpl implements IProductService {

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategoryLessPrice(String category, double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCatBrand(String category, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameContainingOffers(String productChoice, String offers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByBrandOffers(String brand, String offers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameContainingMfgAfter(String name, String dateafter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameContainingDelivery(String name, String delivery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameContainingPayment(String name, String paymenttype) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByNameContainingBrand(String name, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountByCategory(String category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
