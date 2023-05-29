package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.dto.CustomerDto;

public interface ICustomerService {

	ResponseEntity<String> addCustomer(CustomerDto dto);

	List<CustomerDto> findAll();

	CustomerDto findById(Integer id);

}
