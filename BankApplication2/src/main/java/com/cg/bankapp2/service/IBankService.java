package com.cg.bankapp2.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.exceptions.AccountNotFoundException;

public interface IBankService{

	ResponseEntity<BankAccountDto> findById(Integer id) throws AccountNotFoundException;

	List<BankAccountDto> findAllAccounts() throws AccountNotFoundException;
	
	BankAccountDto findByIdByFC(Integer id);
	
	List<BankAccountDto> findAllByFC();

}
