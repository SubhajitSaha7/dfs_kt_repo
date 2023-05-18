package com.cg.bankapp2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.exceptions.AccountNotFoundException;
import com.cg.bankapp2.service.IBankService;

@RestController
public class BankRestController {
	
	@Autowired
	private IBankService service;
	
	private static final Logger log = LoggerFactory.getLogger(BankRestController.class);
	
	@GetMapping("accounts")
	public List<BankAccountDto> getAllAccounts() throws AccountNotFoundException {
		log.info("Controller - getAllAccounts()");
		return service.findAllAccounts();
		
	}
	
	@GetMapping("account/{cid}")
	public BankAccountDto getById(@PathVariable("cid") Integer id) throws AccountNotFoundException {
		log.info("Controller - getById()");
		return service.findById(id);
	}
}
