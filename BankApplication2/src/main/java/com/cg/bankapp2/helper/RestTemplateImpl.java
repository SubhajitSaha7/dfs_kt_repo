package com.cg.bankapp2.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.eo.BankEO;
import com.cg.bankapp2.util.Bank2Constants;

@Component
public class RestTemplateImpl implements IRestTemplate{
	
	private static final Logger log = LoggerFactory.getLogger(BankEO.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public BankAccountDto findById(Integer id) {
		log.info("RestTemplate - findById() - URL");
		String url = Bank2Constants.URL_BANKAPP + "/account/{id}";
		return restTemplate.getForObject(url, BankAccountDto.class, id);
	}

	@Override
	public List<BankAccountDto> findAll() {
		log.info("RestTemplate - findAll() - URL");
		String url = Bank2Constants.URL_BANKAPP + "/accounts";
		ResponseEntity<List<BankAccountDto>> accountsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<BankAccountDto>>() {
		});
		List<BankAccountDto> lst = accountsResponse.getBody();
		return lst;
	}
	
	
}
