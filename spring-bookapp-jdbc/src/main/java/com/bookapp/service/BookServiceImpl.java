package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	

	private IBookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(Book book) {
		bookRepository.addBook(book);

	}

	@Override
	public void updateBook(int bookId, double price) {
		bookRepository.updateBook(bookId, price);
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteBook(bookId);
	}

	@Override
	public List<Book> getAll() {
		return bookRepository
				.findAll()
				.stream()
				.sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
				.toList();
	}

	@Override
	public List<Book> getByAuthorHaving(String author) throws BookNotFoundException {
		return bookRepository
				.findByAuthorHaving(author)
				.stream()
				.sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
				.toList();
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTitlesByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		return bookRepository
				.findByCategory(category)
				.stream()
				.sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle()))
				.toList();
	}

	@Override
	public Book getById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByAuthorLesserPrice(String author, double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTitlesHaving(String title) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByCategory(String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
