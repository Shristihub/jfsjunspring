package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.util.ProductUtil;
@Service
public class ProductServiceImpl implements IProductService {

	private ProductUtil productUtil;
	@Autowired
	public void setProductUtil(ProductUtil productUtil) {
		this.productUtil = productUtil;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = productUtil.showProducts();
		return products;
	}

	@Override
	public List<Product> getByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByLesserPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProductNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
