package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringBootProductappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductappApplication.class, args);
	}

	@Autowired
	IProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
		productService.getAll().forEach(System.out::println);
	}

}
