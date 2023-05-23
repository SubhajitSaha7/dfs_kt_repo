package com.cg.bankapp2.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccountDto{
	
		private static final Logger log = LoggerFactory.getLogger(BankAccountDto.class);
		
		private Integer custId;
		
		private Integer accountNumber;
		
		private Integer ifscCode;
		
		private String customerName;

		private Integer phoneNumber;
		
		private String city;

		public BankAccountDto() {
		}

		public BankAccountDto(Integer custId, Integer accountNumber, Integer ifscCode, String customerName,
				Integer phoneNumber, String city) {
			super();
			this.custId = custId;
			this.accountNumber = accountNumber;
			this.ifscCode = ifscCode;
			this.customerName = customerName;
			this.phoneNumber = phoneNumber;
			this.city = city;
			log.info("BankAccountDTO");
		}

		public BankAccountDto(Integer accountNumber, Integer ifscCode, String customerName, Integer phoneNumber,
				String city) {
			super();
			this.accountNumber = accountNumber;
			this.ifscCode = ifscCode;
			this.customerName = customerName;
			this.phoneNumber = phoneNumber;
			this.city = city;
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
