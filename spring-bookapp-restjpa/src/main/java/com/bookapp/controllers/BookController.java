package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {
	@Autowired
	private IBookService bookService;

//	http://localhost:8081/book-api/v1/books
		@PostMapping("/books")
		void addBook(@RequestBody Book book) {
			bookService.addBook(book);
		}
//		http://localhost:8081/book-api/v1/books
		@PutMapping("/books")
		void updateBook(@RequestBody Book book){
		 bookService.updateBook(book);	
		}
		
//		http://localhost:8081/book-api/v1/books/bookid/1
		@DeleteMapping("/books/bookid/{bookId}")
		void deleteBook(@PathVariable int bookId){
			bookService.deleteBook(bookId);
		}
		
//		http://localhost:8081/book-api/v1/books
		@GetMapping("/books")
		List<Book> getAll(){
			return bookService.getAll();
		}
		
//		http://localhost:8081/book-api/v1/books/bookId?bookId=10
		@GetMapping("/books/bookId")
		Book getById(@RequestParam int bookId) {
			return bookService.getById(bookId);
		}
		
//		http://localhost:8081/book-api/v1/books/author/Kathy
		@GetMapping("/books/author/{author}")
		List<Book> getByAuth(@PathVariable String author){
			return bookService.getByAuth(author);
		}
		
//		http://localhost:8081/book-api/v1/books/price/1000
		@GetMapping("/books/price/{price}")
		List<Book> getByLesserPrice(@PathVariable double price) {
			return bookService.getByLesserPrice(price);
		}
		
//		http://localhost:8081/book-api/v1/books/category?category=fiction
		@GetMapping("/books/category")
		List<Book> getByCategory(@RequestParam String category) {
			return bookService.getByCategory(category);
		}
		
//		http://localhost:8081/book-api/v1/books/cont/category/fiction
		@GetMapping("/books/count/category/{category}")
		long getCountByCategory(@PathVariable String category) {
			return bookService.getCountByCategory(category);
		}
		
//		http://localhost:8081/book-api/v1/books/authorprice?author=kathy&cost=2000
		@GetMapping("/books/authorprice")
		List<Book> getByAuthorLesserPrice(@RequestParam String author,@RequestParam("cost") double price) {
			return bookService.getByAuthorLesserPrice(author, price);
		}
		@GetMapping("/books/title/{title}")
		List<Book> getTitlesHaving(@PathVariable String title){
			return bookService.getTitlesHaving(title);
		}
//		http://localhost:8081/book-api/v1/books/title/Java in Action/price/2000
		@GetMapping("/books/title/{title}/price/{price}")
		List<Book> getByTitleLessPrice(@PathVariable String title,@PathVariable double price) {
			return bookService.getByTitleLessPrice(title, price);
		}
		
	
	
	
}
