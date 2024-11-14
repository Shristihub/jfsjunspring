package com.productapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Brand {
	@Id // for primary key
	@GeneratedValue(generator = "brand_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen",sequenceName = "brand_seq",initialValue = 1,allocationSize = 1)
	private Integer brandId;
	private String brandName; 
	
	private BrandTypes type; // clothing, electronics,
	@ToString.Exclude
	@OneToMany
	private List<Product> products;
	public Brand( String brandName, BrandTypes type) {
		super();
		this.brandName = brandName;
		this.type = type;
	}
}
