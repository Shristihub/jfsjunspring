package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJpaApplication.class, args);
	}

	@Autowired
	IBookService bookService;
	@Override
	public void run(String... args) throws Exception {

		Book book = new Book("Spring in Action","Princy",780.0,"Tech");
//		bookService.addBook(book);
		Book book1 = new Book("Secret","Rhonda",560.0,"selfhelp");
//		bookService.addBook(book1);
		Book book2 = new Book("Atomic Habits","Steve",700.0,"selfhelp");
//		bookService.addBook(book2);
		
		System.out.println();
		System.out.println("Get all");
		bookService.getAll().forEach(System.out::println);
		System.out.println();
//		Book nbook = bookService.getById(2);
//		nbook.setPrice(500);
//		nbook.setTitle("The 5am club");
//		bookService.updateBook(nbook);
//		System.out.println();
//		bookService.getAll().forEach(System.out::println);
		
//		System.out.println("Get By Author");
//		bookService.getByAuth("Robin").forEach(System.out::println);
//		System.out.println();
//		System.out.println("Get By Price");
//		bookService.getByLesserPrice(700).forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get By Category");
//		bookService.getByCategory("selfhelp").forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get By Author and lesser");
//		bookService.getByAuthorLesserPrice("Robin",700).forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get By Titles");
//		bookService.getTitlesHaving("a").forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get By Title and lesser");
//		bookService.getByTitleLessPrice("Secret",700).forEach(System.out::println);
//		System.out.println();
		
//		System.out.println("Get By Title ");
//		bookService.getByTitle("Secret").forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get By Title and cate ");
//		bookService.getByTitleAndCategory("Secret","selfhelp").forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get By author category ");
//		bookService.getByCatAuth("selfhelp","Steve").forEach(System.out::println);
//		System.out.println();
//		
//		System.out.println("Get All ");
//		bookService.getAllBooks().forEach(System.out::println);
//		System.out.println();
		
		System.out.println("Get count by category ");
		long count  = bookService.getCountByCategory("selfhelp");
		System.out.println(count);
	}

}
