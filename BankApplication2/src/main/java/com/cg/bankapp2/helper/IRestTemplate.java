package com.cg.bankapp2.helper;

import java.util.List;

import com.cg.bankapp2.dto.BankAccountDto;

public interface IRestTemplate {

	BankAccountDto findById(Integer id);

	List<BankAccountDto> findAll();

}
