package com.productapp.model;

public enum OfferTypes {
	
//	cash back,bank offer,partner offer,no cost emi
	
	CASH("CASH BACK"),
	PARTNER("BANK OFFER"),
	BANK("PARTNER OFFER"),
	EMI("NO COST EMI");
	
	private String type;

	private OfferTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
