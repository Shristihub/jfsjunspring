package com.bookapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // here the table name will be book
//@Table("book_details") // to give a different table name

@NamedQuery(name = "getByCatAuth",
            query="from Book b where b.category=?1 and b.author=?2"
		)
@NamedQueries(value = {
 @NamedQuery(name = "getByTitle", query="from Book b where b.title=?1"),
 @NamedQuery(name = "getByTitleAndCategory",query="from Book b where b.title=?1 and b.category=?2")
})
@NamedNativeQuery(name = "getAll" , query="select * from book", resultClass = Book.class)
public class Book {
	@Column(length=30) // similar to varchar(30)
	private String title;
	@Column(length=30)
	private String author;
	@Column(name="cost") // to give a different column name
	private double price;
	@Column(length=30)
	private String category;
	@Id // for primary key
	// auto increment with step of 50
	@GeneratedValue  
	// column name will be book_id
	private Integer bookId;
	public Book(String title, String author, double price, String category) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	

}
