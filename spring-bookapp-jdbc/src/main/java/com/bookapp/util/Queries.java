package com.bookapp.util;

public class Queries {

	public static final String INSERTQUERY = 
			"""
			insert into book(title,author,price,category)
			  values(?,?,?,?)
					""";
	public static final String UPDATEQUERY = "update Book set price=? where book_id=?";
	public static final String DELETEQUERY = "delete from book where book_id=?";
	public static final String SELECTQUERY = "select * from book"; 
	public static final String SELECTQUERYBYAUTHOR = "select * from book where author like ?";
	public static final String SELECTQUERYBYCATEGORY = "select * from book where category = ?";
}
