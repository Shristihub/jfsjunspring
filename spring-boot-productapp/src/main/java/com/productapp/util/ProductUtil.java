package com.productapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.productapp.model.Category;
import com.productapp.model.Product;
@Component
public class ProductUtil {

	public List<Product> showProducts(){
		String gadgets = Category.GADGETS.getCategory();
		String elect = Category.ELECTRONICS.getCategory();
		String stationary = Category.STATIONARY.getCategory();
		
		return Arrays.asList(
			new Product("Mobile",1,"OnePlus",40000,gadgets),
			new Product("Laptop",2,"Dell",140000,elect),
			new Product("Headphones",3,"OnePlus",4000,gadgets),
			new Product("Pencils",4,"Camlin",100,stationary),
			new Product("Crayons",5,"Camlin",320,stationary),
			new Product("Webcam",6,"Logitech",1400,gadgets)
			
				);
				
	}
}
