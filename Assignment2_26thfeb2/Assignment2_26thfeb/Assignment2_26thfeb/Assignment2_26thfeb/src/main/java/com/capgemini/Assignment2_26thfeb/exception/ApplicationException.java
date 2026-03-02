package com.capgemini.Assignment2_26thfeb.exception;



import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ApplicationException {
	//acts as a catch block to handle exception
		@ExceptionHandler(Exception.class)
		public String handleException() {
			return "Exception Handle Method";
		}
		
		@ExceptionHandler(DataNotExist.class)
		public String handleException1() {
			return "Data Not Exist";
		}


}

