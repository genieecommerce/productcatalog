package com.geniecommerce.productcatalog.exceptions;

public class ProductNotfoundException extends RuntimeException{

	public ProductNotfoundException() {
		super("Product could not be found");
		// TODO Auto-generated constructor stub
	}

	public ProductNotfoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductNotfoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductNotfoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductNotfoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
