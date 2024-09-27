package com.productapp.model;

public enum Category {

	GADGETS("gadgets"), ELECTRONICS("electronics"), STATIONARY("stationary");

	private String category;

	private Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

}
