package com.hotel.exception;

 
 
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String messages){
		super(messages);
	}
	
	public ResourceNotFoundException(){
		super("Resource not found..!");
	}
}
