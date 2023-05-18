package com.cg.bankapp2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.service.IBankService;

@RestController
@RequestMapping(value = "/feign")
public class FeignClientController {
	
	@Autowired
	private IBankService service;
	
	private static final Logger log = LoggerFactory.getLogger(BankRestController.class);
	
	@GetMapping("/account/{cid}")
    public BankAccountDto getById(@PathVariable("cid") Integer id) {
		log.info("FeignClientController - getById()");
        return service.findByIdByFC(id);
    }
	
	@GetMapping("/accounts")
	public List<BankAccountDto> getAllAccounts() {
		log.info("FeignClientController - getAllAccounts()");
		return service.findAllByFC();
	}

}
