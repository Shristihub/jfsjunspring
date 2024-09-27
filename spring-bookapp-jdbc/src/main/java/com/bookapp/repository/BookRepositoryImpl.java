package com.bookapp.repository;

import static com.bookapp.util.Queries.DELETEQUERY;
import static com.bookapp.util.Queries.INSERTQUERY;
import static com.bookapp.util.Queries.SELECTQUERY;
import static com.bookapp.util.Queries.SELECTQUERYBYAUTHOR;
import static com.bookapp.util.Queries.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

@Repository
public class BookRepositoryImpl implements IBookRepository{
	
	private JdbcTemplate jdbcTemplate;
	public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addBook(Book book) {
		Object[] bookarr = 
			{book.getTitle(),book.getAuthor(),book.getPrice(),book.getCategory()};
		int updatedCount = jdbcTemplate.update(INSERTQUERY,bookarr);
		System.out.println(updatedCount);
	}

	@Override
	public void updateBook(int bookId, double price) {
		int updatedCount = jdbcTemplate.update(UPDATEQUERY,price,bookId);
		System.out.println(updatedCount);
	}

	@Override
	public void deleteBook(int bookId) {
		int updatedCount = jdbcTemplate.update(DELETEQUERY,bookId);
		System.out.println(updatedCount);
		
	}

	@Override
	public List<Book> findAll() {
		RowMapper<Book> rowMapper = new BookMapper();
		List <Book> books = jdbcTemplate.query(SELECTQUERY,rowMapper);
		return books;
	}

	@Override
	public List<Book> findByAuthorHaving(String author) throws BookNotFoundException {
//		List <Book> books = jdbcTemplate.query(SELECTQUERYBYAUTHOR, new BookMapper());
		List <Book> books = jdbcTemplate.query(SELECTQUERYBYAUTHOR,new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				String title = rs.getString("title");
				Book book = new Book();
				book.setTitle(title);
				book.setAuthor(rs.getString("author"));
				book.setBookId(rs.getInt("book_id"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getDouble("price"));
				return book;
			}
			
		},"%"+author+"%");
		return books;
	}

	@Override
	public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findTitlesByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
		List <Book> books = jdbcTemplate.query(SELECTQUERYBYCATEGORY,(rs, rowNum)->{
			String title = rs.getString("title");
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(rs.getString("author"));
			book.setBookId(rs.getInt("book_id"));
			book.setCategory(rs.getString("category"));
			book.setPrice(rs.getDouble("price"));
			return book;
		},category);
		return books;
	}

	@Override
	public Optional<Book> findById(int bookId) {
		Book book = jdbcTemplate.queryForObject(SELECTQUERYBYCATEGORY,new  BookMapper() , null);
		return Optional.of(book);
	}

	@Override
	public List<Book> findByAuthorLesserPrice(String author, double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findTitlesHaving(String title) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findCountByCategory(String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
