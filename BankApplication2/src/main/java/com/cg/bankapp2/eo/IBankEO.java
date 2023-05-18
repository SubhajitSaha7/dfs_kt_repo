package com.cg.bankapp2.eo;

import java.util.List;

import com.cg.bankapp2.dto.BankAccountDto;

public interface IBankEO {

	BankAccountDto findById(Integer id);
	List<BankAccountDto> findAll();
	
	BankAccountDto findByIdByFC(Integer id);
	List<BankAccountDto> findAllByFC();
}
