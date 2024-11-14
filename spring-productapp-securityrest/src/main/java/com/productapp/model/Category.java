package com.productapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Category {
	
	@Id // for primary key
	@GeneratedValue(generator = "category_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "category_gen",sequenceName = "category_seq",initialValue = 1,allocationSize = 1)
	private Integer categoryId;
	@Column(length = 30)
	private String categoryName;
	@Column(length = 30)
	private String subCategory;
	@ManyToMany
	private List<Product> products;
	public Category(String categoryName, String subCategory) {
		super();
		this.categoryName = categoryName;
		this.subCategory = subCategory;
	}
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", subCategory=" + subCategory + "]";
	}
	
}
