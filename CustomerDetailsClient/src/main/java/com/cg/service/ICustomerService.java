package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.dto.CustomerDto;

public interface ICustomerService {

	List<CustomerDto> findAll();

	ResponseEntity<CustomerDto> findById(Integer id);

}
