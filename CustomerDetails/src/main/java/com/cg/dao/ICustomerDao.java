package com.cg.dao;

import java.util.List;

import com.cg.dto.CustomerDto;

public interface ICustomerDao {

	CustomerDto findById(Integer id);

	List<CustomerDto> findAll();

	int save(CustomerDto dto);

}
