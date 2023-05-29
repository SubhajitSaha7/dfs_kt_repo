package com.cg.bankapp2.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.feign.IFeignClient;
import com.cg.bankapp2.helper.IRestTemplate;

@Component
public class BankEO implements IBankEO{

	@Autowired
	private IRestTemplate restTemplate;
	
	@Autowired
	private IFeignClient feignClient;
	
	private static final Logger log = LoggerFactory.getLogger(BankEO.class);
	
	@Override
	public List<BankAccountDto> findAll() {
		log.info("EO - findAll()");
		return restTemplate.findAll();
	}

	@Override
	public ResponseEntity<BankAccountDto> findById(Integer id) {
		log.info("EO - findById()");
		return restTemplate.findById(id);
	}

	@Override
	public BankAccountDto findByIdByFC(Integer id) {
		log.info("EO - findByIdByFC() - calling IFeignClient API");
		return feignClient.findByIdByFC(id);
	}

	@Override
	public List<BankAccountDto> findAllByFC() {
		log.info("EO - findAllByFC() - calling IFeignClient API");
		return feignClient.findAllAccountsByFC();
	}

	
}
