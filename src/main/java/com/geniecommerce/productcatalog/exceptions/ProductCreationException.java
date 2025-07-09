package com.geniecommerce.productcatalog.exceptions;

public class ProductCreationException extends RuntimeException{

	public ProductCreationException() {
		super("Product creation failed");
		// TODO Auto-generated constructor stub
	}

	public ProductCreationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductCreationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductCreationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductCreationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
