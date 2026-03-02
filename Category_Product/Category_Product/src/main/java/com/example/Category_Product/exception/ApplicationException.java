package com.example.Category_Product.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {

	@ExceptionHandler(CategoryNotFoundException.class)
	public String handleException(CategoryNotFoundException ex) {
		return ex.getMessage();
	}
}
