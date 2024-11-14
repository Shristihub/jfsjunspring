package com.productapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ApiErrors {

	private String message;
	private HttpStatus status;
	private int errorcode;
	private LocalDateTime timestamp;
}
