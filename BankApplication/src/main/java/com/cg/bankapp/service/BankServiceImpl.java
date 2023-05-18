package com.cg.bankapp.service;

import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cg.bankapp.bo.IBankBo;
import com.cg.bankapp.eo.BankEO;
import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.vo.BankAccountVo;

@Component
public class BankServiceImpl implements IBankService{
	
	@Autowired
	private IBankBo bo;
	
	private static final Logger log = LoggerFactory.getLogger(BankEO.class);

	@Override
	public ResponseEntity<String> addBankAccount(BankAccountVo bvo) {
		log.info("Service - addbankAccount()");
		return bo.addBankAccount(bvo);
	}

	@Override
	public List<BankAccountVo> findAllAccounts() throws AccountNotFoundException {
		log.info("Service - findAllAccounts()");
		return bo.findAllAccounts();
	}

	@Override
	public ResponseEntity<String> checkHealth() throws JdbcSQLSyntaxErrorException {
		log.info("Service - checkHealth()");
		return bo.checkHealth();
	}

	@Override
	public BankAccountVo findById(Integer id) throws AccountNotFoundException {
		log.info("Service - findById()");
		return bo.findById(id);
	}
	
	
}
