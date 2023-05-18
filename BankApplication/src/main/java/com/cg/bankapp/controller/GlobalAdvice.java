package com.cg.bankapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.exceptions.ValidateBankException;
import com.cg.bankapp.messages.BankErrorMessage;

@RestControllerAdvice
public class GlobalAdvice {

	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public BankErrorMessage handleAccountNotFoundException(AccountNotFoundException ex) {
		return new BankErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
	}
	
	@ExceptionHandler(ValidateBankException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public BankErrorMessage handleValidationException(ValidateBankException ex) {
		List<String> errors = ex.getErrors().stream().map(err -> err.getDefaultMessage()).collect(Collectors.toList());
		return new BankErrorMessage(HttpStatus.BAD_REQUEST.toString(), errors);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
	public String handleException(Exception e) {
		return e.getMessage();
	}
}
