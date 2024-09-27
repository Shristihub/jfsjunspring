package com.greeterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greeterapp.service.IGreeterService;

@SpringBootApplication
public class SpringBootGreeterappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGreeterappApplication.class, args);
	}

	@Autowired
	IGreeterService greeterService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello");
		System.out.println(greeterService.greetUser("Priya"));
		greeterService.showMessages().forEach(System.out::println);
		
		
		
		
	}

}
