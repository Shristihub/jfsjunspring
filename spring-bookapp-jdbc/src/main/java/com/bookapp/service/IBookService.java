package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	// CRUD OPERATion
	void addBook(Book book);
	void updateBook(int bookId, double price);
	void deleteBook(int bookId);
	
	
	List<Book> getAll();
	List<Book> getByAuthorHaving(String author)throws BookNotFoundException;
	List<Book> getByLesserPrice(double price) throws BookNotFoundException;
	List<String> getTitlesByAuthor(String author);
	List<Book> getByCategory(String category) throws BookNotFoundException;
	Book getById(int bookId);
	List<Book> getByAuthorLesserPrice(String author,double price) throws BookNotFoundException;
	List<String> getTitlesHaving(String title)throws BookNotFoundException;
	int getCountByCategory(String category) throws BookNotFoundException;
	
	
	
	
	
}
