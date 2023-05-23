package com.cg.bankapp2.helper;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bankapp2.dto.BankAccountDto;

public interface IRestTemplate {

	ResponseEntity<BankAccountDto> findById(Integer id);

	List<BankAccountDto> findAll();


}
