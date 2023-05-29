package com.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.dto.CustomerDto;
import com.cg.helper.IRestTemplate;
import com.cg.helper.RestTemplateImpl;

@Service("customerservice")
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private IRestTemplate template;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public List<CustomerDto> findAll() {
		log.info("Service - findAllAccounts()");
		List<CustomerDto> lst1 = template.findAll();
		return lst1;
	}
	
	@Override
	public ResponseEntity<CustomerDto> findById(Integer id) {
		log.info("Service - findById()");
		return template.findById(id);
	}
	
	public CustomerServiceImpl(RestTemplateImpl template2) {
		this.template = template2;
	}

}
