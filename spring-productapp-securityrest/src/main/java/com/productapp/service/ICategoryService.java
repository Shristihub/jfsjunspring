package com.productapp.service;

import java.util.List;

import com.productapp.model.Category;

public interface ICategoryService {


	void addCategory(Category category);
	void updateProduct(Category category);
	void deleteProduct(int categoryId);
	Category getById(int categoryId);
	List<Category> getAll();
}
