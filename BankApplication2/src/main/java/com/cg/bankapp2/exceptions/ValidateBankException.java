package com.cg.bankapp2.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateBankException extends Exception{
	
	private List<FieldError> errors;

	public ValidateBankException() {
		super();
	}
	
	public ValidateBankException(String message) {
		super(message);
	}

	public ValidateBankException(List<FieldError> errors) {
		super();
		this.errors=errors;
	}
	
	public List<FieldError> getErrors() {
		return errors;
	}


}
