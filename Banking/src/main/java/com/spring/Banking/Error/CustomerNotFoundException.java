package com.spring.Banking.Error;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String id) {
		super("Customer Not found with id" + id);
	}
}
