package com.cg.bankapp.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.bankapp.util.BankConstants;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BankAccountVo {
	
	private static final Logger log = LoggerFactory.getLogger(BankAccountVo.class);
	
	private Integer custId;
	
	@NotNull(message = BankConstants.NOT_NULL_MESSAGE)
	private Integer accountNumber;
	
	@NotNull(message = BankConstants.NOT_NULL_MESSAGE)
	private Integer ifscCode;

	@NotBlank(message = BankConstants.NOT_BLANK_MESSAGE)
	private String customerName;
	
	private Integer phoneNumber;
	
	private String city;

	public BankAccountVo() {
	}

	public BankAccountVo(Integer custId, Integer accountNumber, Integer ifscCode, String customerName,
			Integer phoneNumber, String city) {
		super();
		this.custId = custId;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		log.info("BankAccountVO");
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(Integer ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
