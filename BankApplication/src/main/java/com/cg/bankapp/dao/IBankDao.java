package com.cg.bankapp.dao;

import java.util.List;

import com.cg.bankapp.dto.BankAccountDto;

public interface IBankDao{

	int save(BankAccountDto bdto);
	
	List<BankAccountDto> findAll();
	
	List<Object> check();
	
	BankAccountDto findById(Integer id);

}
