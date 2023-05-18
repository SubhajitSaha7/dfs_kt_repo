package com.cg.bankapp.eo;

import java.util.List;

import com.cg.bankapp.dto.BankAccountDto;

public interface IBankEO {

	int save(BankAccountDto bdto);

	List<BankAccountDto> findAll();

	List<Object> check();

	BankAccountDto findById(Integer id);
}
