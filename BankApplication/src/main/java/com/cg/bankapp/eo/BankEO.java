package com.cg.bankapp.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp.dao.IBankDao;
import com.cg.bankapp.dto.BankAccountDto;

@Component
public class BankEO implements IBankEO{

	@Autowired
	private IBankDao dao;
	
	private static final Logger log = LoggerFactory.getLogger(BankEO.class);
	
	@Override
	public int save(BankAccountDto bdto) {
		log.info("EO - save()");
		return dao.save(bdto);
	}

	@Override
	public List<BankAccountDto> findAll() {
		log.info("EO - findAll()");
		return dao.findAll();
	}

	@Override
	public List<Object> check() {
		log.info("EO - check()");
		return dao.check();
	}

	@Override
	public BankAccountDto findById(Integer id) {
		log.info("EO - findById()");
		return dao.findById(id);
	}

}
