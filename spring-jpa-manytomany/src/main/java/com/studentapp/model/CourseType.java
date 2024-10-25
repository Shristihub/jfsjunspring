package com.studentapp.model;

public enum CourseType {
	FRONTEND("FRONTEND"),BACKEND("BACKEND"),
	TESTING("TESTING"),DESIGN("DESIGN"),
	CLOUD("CLOUD COMPUTING"),ML("MACHINE LEARNING");
	private String type;

	private CourseType(String type) {
		this.type = type;
	}

	public String getCourseType() {
		return type;
	}
}
