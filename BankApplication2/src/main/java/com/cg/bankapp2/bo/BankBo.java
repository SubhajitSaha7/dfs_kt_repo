package com.cg.bankapp2.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.eo.IBankEO;
import com.cg.bankapp2.exceptions.AccountNotFoundException;
import com.cg.bankapp2.util.Bank2Constants;

@Service("bankservice")
public class BankBo implements IBankBo{
	
	@Autowired
	private IBankEO bankeo;
	
	private static final Logger log = LoggerFactory.getLogger(BankBo.class);
	
	@Override
	public List<BankAccountDto> findAllAccounts() throws AccountNotFoundException {
		log.info("BO - findAllAccounts()");
		List<BankAccountDto> lst1 = bankeo.findAll();
		if(lst1.isEmpty()) {
			throw new AccountNotFoundException(Bank2Constants.ACCOUNT_NOT_EXIST);
		}
		
		return lst1;
	}
	
	@Override
	public BankAccountDto findById(Integer id) throws AccountNotFoundException {
		log.info("BO - findById()");
		try {
			BankAccountDto dto =  bankeo.findById(id);
			return dto;
		}catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public BankAccountDto findByIdByFC(Integer id) {
		log.info("BO - findByIdByFC()");
		return bankeo.findByIdByFC(id);
	}

	@Override
	public List<BankAccountDto> findAllByFC() {
		log.info("BO - findAllByFC()");
		return bankeo.findAllByFC();
	}

}
