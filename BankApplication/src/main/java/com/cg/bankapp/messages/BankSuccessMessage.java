package com.cg.bankapp.messages;

public class BankSuccessMessage {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BankSuccessMessage(String message) {
		super();
		this.message = message;
	}

}
