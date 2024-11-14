package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book getById(int bookId) {
		return bookRepository.findById(bookId)
		.orElseThrow(()->new BookNotFoundException("invalid id"));
	
	}

	@Override
	public List<Book> getByAuth(String author)  {
		List<Book> books = bookRepository.findByAuthor(author);
		if(books.isEmpty())
			throw new BookNotFoundException("author not found");
//		return books.stream().sorted((b1,b2)->b1.getTitle().compareTo(b2.getTitle())).toList();
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
	}

	@Override
	public List<Book> getByLesserPrice(double price)  {
		List<Book> books = bookRepository.findByPriceLessThan(price);
		if(books.isEmpty())
			throw new BookNotFoundException("book with lesser price not found");
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
	}

	@Override
	public List<Book> getByCategory(String category) {
		List<Book> books = bookRepository.findBookByCat(category);
		if(books.isEmpty())
			throw new BookNotFoundException("book with category not found");
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
	}

	@Override
	public List<Book> getByAuthorLesserPrice(String author, double price) {
		List<Book> books = bookRepository.findByAuthPrice(author, price);
		if(books.isEmpty())
			throw new BookNotFoundException("book with this author and lesser price not found");
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
	}

	@Override
	public List<Book> getTitlesHaving(String choice) {
		List<Book> books = bookRepository.findTitlesHaving("%"+choice+"%");
		if(books.isEmpty())
			throw new BookNotFoundException("book with lesser price not found");
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
	}

	@Override
	public List<Book> getByTitleLessPrice(String title, double price) throws BookNotFoundException {
		List<Book> books = bookRepository.findByTitPrice(title, price);
		if(books.isEmpty())
			throw new BookNotFoundException("book with this title and lesser price not found");
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).toList();
	}

	
	@Override
	public long getCountByCategory(String category) throws BookNotFoundException {
		return bookRepository.countByCategory(category);
	}



}
