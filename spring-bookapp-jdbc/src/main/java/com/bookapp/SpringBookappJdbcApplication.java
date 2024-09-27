package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}
	@Autowired
	IBookService bookService;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("in main");
//		bookService.addBook(new Book("CSS","Mohan",800,"Tech"));
//		bookService.addBook(new Book("7 Habits","Rohan",600,"selfhelp"));
		
//		bookService.updateBook(1, 750);
//		bookService.getAll().forEach(System.out::println);
		bookService.getByAuthorHaving("o").forEach(System.out::println);
		
		
	}

}
