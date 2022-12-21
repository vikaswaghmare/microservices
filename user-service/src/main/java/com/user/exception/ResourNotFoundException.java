package com.user.exception;

public class ResourNotFoundException extends RuntimeException {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public ResourNotFoundException() {
			super("Resource not found Exception");
		}
		
		public ResourNotFoundException(String messages){
			super(messages);
		}
}
