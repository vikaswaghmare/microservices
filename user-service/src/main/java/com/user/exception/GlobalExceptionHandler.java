package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.payload.ApiResponse;

 

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourNotFoundException ex){
		
		ApiResponse response=new ApiResponse(ex.getMessage(),true,HttpStatus.NOT_FOUND);			
		
			 return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
}
