package com.ust.app.customerapp.exception;

public class CustomerAlreadyExistsException extends RuntimeException{
	public CustomerAlreadyExistsException(String message) {
		super(message);
	}
}
