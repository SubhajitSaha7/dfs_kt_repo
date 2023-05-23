package com.cg.bankapp2.helper;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.eo.BankEO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
@Configuration
public class RestTemplateImpl implements IRestTemplate{
	
	private static final Logger log = LoggerFactory.getLogger(BankEO.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${bankapp.url}")
	private String urlAll;
	
	@Value("${bankapp.urlbyid}")
	private String urlById;

	@Override
	public ResponseEntity<BankAccountDto> findById(Integer id) {
		log.info("RestTemplate - findById() - URL");
		String url = urlById + "/account/" + Integer.toString(id);
		ResponseEntity<BankAccountDto> accountsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<BankAccountDto>() {
		});
		return accountsResponse;
	}

	@Override
	public List<BankAccountDto> findAll() {
		log.info("RestTemplate - findAll() - URL");
		//String url = Bank2Constants.URL_BANKAPP + "/accounts";
		String url = urlAll;
		ResponseEntity<List<BankAccountDto>> accountsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<BankAccountDto>>() {
		});
		List<BankAccountDto> lst = accountsResponse.getBody();
		return lst;
	}

	
}
