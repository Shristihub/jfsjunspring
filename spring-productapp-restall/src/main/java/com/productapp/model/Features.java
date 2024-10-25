package com.productapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Features {
	@Id // for primary key
	@GeneratedValue(generator = "features_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "features_gen",sequenceName = "features_seq",initialValue = 1,allocationSize = 1)
	private Integer featuresId;
	private String color;
	private String desc;
	private String material;
	public Features(String color, String desc, String material) {
		super();
		this.color = color;
		this.desc = desc;
		this.material = material;
	} 
	
	
	
}
