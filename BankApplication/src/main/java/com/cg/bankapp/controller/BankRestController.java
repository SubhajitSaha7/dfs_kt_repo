package com.cg.bankapp.controller;

import java.util.List;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.exceptions.ValidateBankException;
import com.cg.bankapp.messages.BankSuccessMessage;
import com.cg.bankapp.service.IBankService;
import com.cg.bankapp.util.BankConstants;
import com.cg.bankapp.vo.BankAccountVo;

import jakarta.validation.Valid;

@RestController
public class BankRestController {
	
	@Autowired
	private IBankService service;
	
	private static final Logger log = LoggerFactory.getLogger(BankRestController.class);
	
	@PostMapping("add")
	public BankSuccessMessage createBankAccount(@Valid @RequestBody BankAccountVo bvo, BindingResult br) throws ValidateBankException, JdbcSQLIntegrityConstraintViolationException {
		log.info("Controller - createBankAccount()");
		if(br.hasErrors()) 
			throw new ValidateBankException(br.getFieldErrors());
		
		service.addBankAccount(bvo);
		return new BankSuccessMessage(BankConstants.BANK_ACCOUNT_ADDED);	
	}
	
	@GetMapping("accounts")
	public List<BankAccountVo> getAllAccounts() throws AccountNotFoundException {
		log.info("Controller - getAllAccounts()");
		return service.findAllAccounts();
		
	}
	
	@GetMapping("health")
	public ResponseEntity<String> checkHealthOfH2() throws JdbcSQLSyntaxErrorException {
		log.info("Controller - checkHealthOfH2()");
		return service.checkHealth();
	}
	
	@GetMapping("account/{cid}")
	public BankAccountVo getById(@PathVariable("cid") Integer id) throws AccountNotFoundException {
		log.info("Controller - getById()");
		return service.findById(id);
	}

}
