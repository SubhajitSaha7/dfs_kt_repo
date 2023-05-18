package com.cg.bankapp2.messages;

import java.util.List;

public class BankErrorMessage {
	
	private String status;
	private String message;
	private List<String> messages;
	
	public BankErrorMessage(String status, List<String> messages) {
		super();
		this.status = status;
		this.messages = messages;
	}

	public BankErrorMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
