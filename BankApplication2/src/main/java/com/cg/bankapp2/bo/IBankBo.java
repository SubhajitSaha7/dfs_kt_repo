package com.cg.bankapp2.bo;

import java.util.List;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.exceptions.AccountNotFoundException;

public interface IBankBo {

	List<BankAccountDto> findAllAccounts() throws AccountNotFoundException;

	BankAccountDto findById(Integer id) throws AccountNotFoundException;
	
	BankAccountDto findByIdByFC(Integer id);
	List<BankAccountDto> findAllByFC();


}
