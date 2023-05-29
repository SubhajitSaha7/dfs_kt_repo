package com.cg.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.dto.CustomerDto;
import com.cg.util.CustomerConstants;

@Repository
public class CustomerRepo implements ICustomerDao{
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerRepo.class);
	
	@Override
	public int save(CustomerDto dto) {
		log.info("Dao - save() - query");
		return jdbctemplate.update(CustomerConstants.INSERT_QUERY,
				new Object[] {dto.getCustomerId(),dto.getCustomerName(),dto.getDateOfBirth(),dto.getPhoneNumber()});
	}

	@Override
	public List<CustomerDto> findAll() {
		log.info("Dao - findAll() - query");
		return jdbctemplate.query(CustomerConstants.FINDALL_QUERY, BeanPropertyRowMapper.newInstance(CustomerDto.class));
	}
	
	@Override
	public CustomerDto findById(Integer id) {
		log.info("Dao - findById() - query");
		return jdbctemplate.queryForObject(CustomerConstants.FINDBYID_QUERY, 
					BeanPropertyRowMapper.newInstance(CustomerDto.class), id);
	}

}
