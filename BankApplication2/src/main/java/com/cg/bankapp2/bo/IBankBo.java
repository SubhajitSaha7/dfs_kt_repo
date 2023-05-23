package com.cg.bankapp2.bo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.exceptions.AccountNotFoundException;

public interface IBankBo {

	List<BankAccountDto> findAllAccounts() throws AccountNotFoundException;

	ResponseEntity<BankAccountDto> findById(Integer id) throws AccountNotFoundException;
	
	BankAccountDto findByIdByFC(Integer id);
	List<BankAccountDto> findAllByFC();



}
