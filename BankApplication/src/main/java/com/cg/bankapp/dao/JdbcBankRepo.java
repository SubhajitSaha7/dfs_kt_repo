package com.cg.bankapp.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import com.cg.bankapp.dto.BankAccountDto;

@Repository
public class JdbcBankRepo implements IBankDao{
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private static final Logger log = LoggerFactory.getLogger(JdbcBankRepo.class);

	@Override
	public int save(BankAccountDto bdto) {
		log.info("Dao - save() - query");
		return jdbctemplate.update("INSERT INTO cg_bank_account (custId,accountNumber,ifscCode,customerName,phoneNumber,city) VALUES (?,?,?,?,?,?)",
				new Object[] {bdto.getCustId(),bdto.getAccountNumber(),bdto.getIfscCode(),bdto.getCustomerName(),bdto.getPhoneNumber(),bdto.getCity()});
	}

	@Override
	public List<BankAccountDto> findAll() {
		log.info("Dao - findAll() - query");
		return jdbctemplate.query("SELECT * FROM cg_bank_account", BeanPropertyRowMapper.newInstance(BankAccountDto.class));
	}

	@Override
	public List<Object> check() {
		log.info("Dao - check() - query");
		return jdbctemplate.query("SELECT * FROM cg_bank", new SingleColumnRowMapper<>());
	}

	@Override
	public BankAccountDto findById(Integer id) {
		log.info("Dao - findById() - query");
		return jdbctemplate.queryForObject("SELECT * FROM cg_bank_account WHERE custId=?", 
					BeanPropertyRowMapper.newInstance(BankAccountDto.class), id);
	}

}
