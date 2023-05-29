package com.cg.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.dao.ICustomerDao;
import com.cg.dto.CustomerDto;
import com.cg.util.CustomerConstants;

import jakarta.transaction.Transactional;

@Service("customerservice")
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerDao dao;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Transactional
	@Override
	public ResponseEntity<String> addCustomer(CustomerDto dto)	{	
		log.info("Service - addCustomer()");
		dao.save(dto);
		return new ResponseEntity<>(CustomerConstants.CUSTOMER_ADDED, HttpStatus.CREATED);
	}
	
	@Override
	public List<CustomerDto> findAll() {
		log.info("Service - findAllAccounts()");
		List<CustomerDto> lst1 = dao.findAll();
		return lst1;
	}
	
	@Override
	public CustomerDto findById(Integer id) {
		log.info("Service - findById()");
		return dao.findById(id);
	}
}
