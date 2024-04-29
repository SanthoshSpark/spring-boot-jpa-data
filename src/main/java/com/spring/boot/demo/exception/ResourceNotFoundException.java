package com.spring.boot.demo.exception;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 7845804876649289371L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
