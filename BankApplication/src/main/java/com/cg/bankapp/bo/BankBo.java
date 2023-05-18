package com.cg.bankapp.bo;

import java.util.ArrayList;
import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bankapp.dto.BankAccountDto;
import com.cg.bankapp.eo.IBankEO;
import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.mapper.BankMapper;
import com.cg.bankapp.util.BankConstants;
import com.cg.bankapp.vo.BankAccountVo;

import jakarta.transaction.Transactional;

@Service("bankservice")
public class BankBo implements IBankBo{
	
	@Autowired
	private IBankEO bankeo;
	
	@Autowired
	private BankMapper mapper;
	
	private static final Logger log = LoggerFactory.getLogger(BankBo.class);
	
	@Transactional
	@Override
	public ResponseEntity<String> addBankAccount(BankAccountVo bvo)	{	
		log.info("BO - addBankAccount()");
		BankAccountDto bdto = mapper.voToDto(bvo); //mapper
	
		bankeo.save(bdto);
		return new ResponseEntity<>(BankConstants.ACCOUNT_CREATED, HttpStatus.CREATED);
	}
	
	@Override
	public List<BankAccountVo> findAllAccounts() throws AccountNotFoundException {
		log.info("BO - findAllAccounts()");
		List<BankAccountDto> lst1 = bankeo.findAll();
		if(lst1.isEmpty()) {
			throw new AccountNotFoundException(BankConstants.ACCOUNT_NOT_EXIST);
		}
		List<BankAccountVo> lst2 = new ArrayList<>();
		BankAccountVo bvo = null;
		for (BankAccountDto dto : lst1) {
			bvo = mapper.dtoToVo(dto);
			lst2.add(bvo);
		}
		return lst2;
	}
	
	@Override
	public ResponseEntity<String> checkHealth() throws JdbcSQLSyntaxErrorException {
		log.info("BO - checkHealth()");
		try {
			bankeo.check();
		}catch (DataAccessException e) {
			return new ResponseEntity<>(BankConstants.DB_CONNECTION_OK, HttpStatus.OK);
		}
		return new ResponseEntity<>(BankConstants.DB_CONNECTION_FAILED, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@Override
	public BankAccountVo findById(Integer id) throws AccountNotFoundException {
		log.info("BO - findById()");
		try {
			BankAccountDto dto =  bankeo.findById(id);
			BankAccountVo bvo = mapper.dtoToVo(dto);
			return bvo;
		}catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

}
