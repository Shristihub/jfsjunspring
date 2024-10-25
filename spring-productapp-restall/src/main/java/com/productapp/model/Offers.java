package com.productapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Offers {
	@Id // for primary key
	@GeneratedValue(generator = "offers_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "offers_gen",sequenceName = "offers_seq",initialValue = 1,allocationSize = 1)
	private String offerId;
	private String offerName; // cash back,bank offer,partner offer,no cost emi
	private String offerDesc;  
	public Offers(String offerName, String offerDesc) {
		super();
		this.offerName = offerName;
		this.offerDesc = offerDesc;
	}
	
	
	
	
}
