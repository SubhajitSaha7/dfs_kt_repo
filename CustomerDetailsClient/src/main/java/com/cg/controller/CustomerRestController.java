package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CustomerDto;
import com.cg.service.ICustomerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service; 
	
	private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	
	@GetMapping("/all")
	public List<CustomerDto> getAllAccounts() {
		log.info("Controller - getAllAccounts()");
		return service.findAll();
		
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<CustomerDto> getById(@PathVariable("cid") Integer id) {
		log.info("Controller - getById()");
		return service.findById(id);
	}

}
