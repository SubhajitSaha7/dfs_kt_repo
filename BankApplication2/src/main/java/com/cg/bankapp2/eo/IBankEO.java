package com.cg.bankapp2.eo;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bankapp2.dto.BankAccountDto;

public interface IBankEO {

	ResponseEntity<BankAccountDto> findById(Integer id);
	List<BankAccountDto> findAll();
	
	BankAccountDto findByIdByFC(Integer id);
	List<BankAccountDto> findAllByFC();
}
