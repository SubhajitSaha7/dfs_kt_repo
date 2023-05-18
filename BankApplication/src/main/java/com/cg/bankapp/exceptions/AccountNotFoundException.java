package com.cg.bankapp.exceptions;

public class AccountNotFoundException extends Exception{

	public AccountNotFoundException() {
		super();
	}
	
	public AccountNotFoundException(String message) {
		super(message);
	}
	
}
