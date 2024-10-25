package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	// CRUD OPERATion
	void addBook(Book book);
	void updateBook(Book book);
	void deleteBook(int bookId);
	List<Book> getAll();
	Book getById(int bookId)throws BookNotFoundException;;
	
	// derived queries
	List<Book> getByAuth(String author)throws BookNotFoundException;
	List<Book> getByLesserPrice(double price) throws BookNotFoundException;
	List<Book> getByCategory(String category) throws BookNotFoundException;
	long getCountByCategory(String category) throws BookNotFoundException;
	
	// custom queries
	List<Book> getByAuthorLesserPrice(String author,double price) throws BookNotFoundException;
	List<Book> getTitlesHaving(String title)throws BookNotFoundException;
	
	//native query
	List<Book> getByTitleLessPrice(String title,double price) throws BookNotFoundException;
	
	
	
}
