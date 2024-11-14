package com.bookapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.ApiErrors;

import jakarta.servlet.http.HttpServletRequest;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String exceptionMessage = ex.getMessage();
		String errorStatus = ex.getStatusCode().toString();
		String path = request.getContextPath();
		
		headers.add("errorInfo", "method not allowed");
		headers.add("exception", exceptionMessage);
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(),exceptionMessage,errorStatus,path);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String exceptionMessage = ex.getMessage();
		String errorStatus = ex.getStatusCode().toString();
		String path = request.getContextPath();
		
		headers.add("errorInfo", status.toString());
		headers.add("exception", exceptionMessage);
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(),exceptionMessage,errorStatus,path);
		return ResponseEntity.status(status).body(errors);	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String exceptionMessage = ex.getMessage();
		String errorStatus = ex.getStatusCode().toString();
		String path = request.getContextPath();
		// DO NOT ADD HEADERS. THEY ARE READ ONLY
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(),exceptionMessage,errorStatus,path);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		System.out.println("inside.....the method");
		String exceptionMessage = ex.getMessage();
		String errorStatus = ex.getStatusCode().toString();
		String path = request.getContextPath();
		System.out.println(exceptionMessage+".... "+errorStatus);
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(),exceptionMessage,errorStatus,path);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String exceptionMessage = ex.getMessage();
		String errorStatus = status.toString();
		String path = request.getContextPath();
		
		headers.add("errorInfo", errorStatus);
		headers.add("exception", exceptionMessage);
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), status.value(),exceptionMessage,errorStatus,path);
		return ResponseEntity.status(status).body(errors);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleException(BookNotFoundException ex){
		String exceptionMessage = ex.getMessage();
		String errorStatus = HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()).toString();
		String path = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("errorInfo", errorStatus);
		headers.add("exception", exceptionMessage);
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),exceptionMessage,errorStatus,path);
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(errors);
	}
}
