package com.cg.controller;

import java.util.List;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CustomerDto;
import com.cg.service.ICustomerService;
import com.cg.util.CustomerConstants;

import jakarta.validation.Valid;

@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	
	@PostMapping("/add")
	public CustomerSuccessMessage createCustomer(@Valid @RequestBody CustomerDto dto, BindingResult br) throws  JdbcSQLIntegrityConstraintViolationException {
		log.info("Controller - createBankAccount()");
		
		service.addCustomer(dto);
		return new CustomerSuccessMessage(CustomerConstants.CUSTOMER_ADDED);	
	}
	
	@GetMapping("/all")
	public List<CustomerDto> getAllAccounts() {
		log.info("Controller - getAllAccounts()");
		return service.findAll();
		
	}
	
	@GetMapping("/{cid}")
	public CustomerDto getById(@PathVariable("cid") Integer id) {
		log.info("Controller - getById()");
		return service.findById(id);
	}

}
