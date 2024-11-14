package com.bookapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {

	LocalDateTime timestamp;
	int status;
	String exceptionMessage; // exception message
	String errorStatus; // status code message
	String path;
}
