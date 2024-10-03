package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;


@Repository
public interface IBookRepository extends JpaRepository<Book, Integer>{
	//derived query
	//findBy
	//readBy
	//getBy
	
	List<Book> findByAuthor(String author);
	List<Book> findByPriceLessThan(double price);
	
	//customquery - JPQL - WRITE USING JAVA DOMAIN MODEL
	// from entity class name where b.propertyname=?
	@Query("from Book b where b.category=?1")
	List<Book> findBookByCat(String category);
	
	@Query("from Book b where b.author=?1 and b.price<?2")
	List<Book> findByAuthPrice(String author,double price);
	
	@Query("from Book b where b.title like ?1")
	List<Book> findTitlesHaving(String title);
	
	// native query - use sql use table name and column name
	@Query
	(value = "select * from book where title=?1 and cost<?2",nativeQuery = true)
	List<Book> findByTitPrice(String title,double price);
	//named queries
	@Query(name = "getByCatAuth")
	List<Book>  findByCatAuth(String category,String author);
	
	@Query(name = "getByTitleAndCategory")
	List<Book> readByTitleAndCat(String title, String category);
	
	@Query(name = "getByTitle")
	List<Book> getAllByTitle(String title);
	
	@Query(name="getAll",nativeQuery = true)
	List<Book> getAllBooks();
	
	long countByCategory(String category);
}
