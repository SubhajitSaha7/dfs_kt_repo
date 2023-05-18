package com.cg.bankapp.bo;

import java.util.List;

import org.h2.jdbc.JdbcSQLSyntaxErrorException;
import org.springframework.http.ResponseEntity;

import com.cg.bankapp.exceptions.AccountNotFoundException;
import com.cg.bankapp.vo.BankAccountVo;

public interface IBankBo {

	ResponseEntity<String> addBankAccount(BankAccountVo bvo);

	List<BankAccountVo> findAllAccounts() throws AccountNotFoundException;

	ResponseEntity<String> checkHealth() throws JdbcSQLSyntaxErrorException;

	BankAccountVo findById(Integer id) throws AccountNotFoundException;

}
