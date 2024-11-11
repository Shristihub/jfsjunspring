package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
public class BookResponseController {
	@Autowired
	private IBookService bookService;

//	http://localhost:8081/book-api/v1/books
	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api adding one book");
		// new resource is created
		return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).build();

	}

//		http://localhost:8081/book-api/v1/books
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api adding one book");
		// new resource is created
		return ResponseEntity.accepted().headers(headers).build();

	}

//		http://localhost:8081/book-api/v1/books/bookid/1
	@DeleteMapping("/books/bookid/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api deleting one book");
		return ResponseEntity.accepted().headers(headers).build();

	}

//		http://localhost:8081/book-api/v1/books
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll() {
		List<Book> books = bookService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books");
		// create an object of ResponseEntity
		ResponseEntity<List<Book>> responseEntity = new ResponseEntity<List<Book>>(books, headers,
				HttpStatusCode.valueOf(HttpStatus.OK.value()));
		return responseEntity;
	}

//		http://localhost:8081/book-api/v1/books/bookId?bookId=10
	@GetMapping("/books/bookId")
	ResponseEntity<Book> getById(@RequestParam int bookId) {
		Book book = bookService.getById(bookId);
		return ResponseEntity.status(HttpStatus.OK).body(book);

	}

//		http://localhost:8081/book-api/v1/books/author/Kathy
	@GetMapping("/books/author/{auth}")
	ResponseEntity<List<Book>> getByAuth(@PathVariable String author) {
		List<Book> books = bookService.getByAuth(author);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books by author");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}

//		http://localhost:8081/book-api/v1/books/price/1000
	@GetMapping("/books/price/{price}")
	ResponseEntity<List<Book>> getByLesserPrice(@PathVariable double price) {
		List<Book> books = bookService.getByLesserPrice(price);
		return ResponseEntity.ok(books);
	}

//		http://localhost:8081/book-api/v1/books/category?category=fiction
	@GetMapping("/books/category")
	ResponseEntity<List<Book>> getByCategory(@RequestParam String category) {
		List<Book> books = bookService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books by category");
		return ResponseEntity.ok().headers(headers).body(books);
	}

//		http://localhost:8081/book-api/v1/books/cont/category/fiction
	@GetMapping("/books/count/category/{category}")
	ResponseEntity<Long> getCountByCategory(@PathVariable String category) {
		long count = bookService.getCountByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books by category");
		return ResponseEntity.ok().headers(headers).body(count);
	}

//		http://localhost:8081/book-api/v1/books/authorprice?author=kathy&cost=2000
	@GetMapping("/books/authorprice")
	ResponseEntity<List<Book>> getByAuthorLesserPrice(@RequestParam String author, @RequestParam("cost") double price) {
		List<Book> books = bookService.getByAuthorLesserPrice(author, price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books by lesser price and author");
		return ResponseEntity.ok().headers(headers).body(books);
	}

	@GetMapping("/books/title/{title}")
	ResponseEntity<List<Book>> getTitlesHaving(@PathVariable String title) {
		List<Book> books = bookService.getTitlesHaving(title);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books by title containing");
		return ResponseEntity.ok().headers(headers).body(books);
	}

//		http://localhost:8081/book-api/v1/books/title/Java in Action/price/2000
	@GetMapping("/books/title/{title}/price/{price}")
	ResponseEntity<List<Book>> getByTitleLessPrice(@PathVariable String title, @PathVariable double price) {
		List<Book> books = bookService.getByTitleLessPrice(title, price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "book api returning books");
		headers.add("desc", "Getting all books by title and lesser price");
		return ResponseEntity.ok().headers(headers).body(books);
	}

}
