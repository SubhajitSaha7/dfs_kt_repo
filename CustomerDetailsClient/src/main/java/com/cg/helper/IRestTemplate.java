package com.cg.helper;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.dto.CustomerDto;

public interface IRestTemplate {

	ResponseEntity<CustomerDto> findById(Integer id);

	List<CustomerDto> findAll();


}
