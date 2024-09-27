package com.bookapp.repository;

import java.util.List;
import java.util.Optional;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookRepository {

	// CRUD OPERATion
	void addBook(Book book);
	void updateBook(int bookId, double price);
	void deleteBook(int bookId);
	
	
	List<Book> findAll();
	List<Book> findByAuthorHaving(String author)throws BookNotFoundException;
	List<Book> findByLesserPrice(double price) throws BookNotFoundException;
	List<String> findTitlesByAuthor(String author);
	List<Book> findByCategory(String category) throws BookNotFoundException;
	Optional<Book> findById(int bookId);
	List<Book> findByAuthorLesserPrice(String author,double price) throws BookNotFoundException;
	List<String> findTitlesHaving(String title)throws BookNotFoundException;
	int findCountByCategory(String category) throws BookNotFoundException;
	
}
