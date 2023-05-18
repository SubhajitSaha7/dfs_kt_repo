package com.cg.bankapp2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.bankapp2.bo.IBankBo;
import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.eo.BankEO;
import com.cg.bankapp2.exceptions.AccountNotFoundException;

@Component
public class BankServiceImpl implements IBankService{
	
	@Autowired
	private IBankBo bo;
	
	private static final Logger log = LoggerFactory.getLogger(BankEO.class);

	@Override
	public List<BankAccountDto> findAllAccounts() throws AccountNotFoundException {
		log.info("Service - findAllAccounts()");
		return bo.findAllAccounts();
	}

	@Override
	public BankAccountDto findById(Integer id) throws AccountNotFoundException {
		log.info("Service - findById()");
		return bo.findById(id);
	}
	
	@Override
	public BankAccountDto findByIdByFC(Integer id) {
		log.info("Service - findByIdByFC()");
		return bo.findByIdByFC(id);
	}

	@Override
	public List<BankAccountDto> findAllByFC() {
		log.info("Service - findAllByFC()");
		return bo.findAllByFC();
	}
}
