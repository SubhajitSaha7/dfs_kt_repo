package com.cg.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cg.dto.CustomerDto;

@Component
@Configuration
public class RestTemplateImpl implements IRestTemplate{
	
	private static final Logger log = LoggerFactory.getLogger(RestTemplateImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<CustomerDto> findById(Integer id) {
		log.info("RestTemplate - findById() - URL");
		String url = "http://localhost:8091/customer/" + Integer.toString(id);
		ResponseEntity<CustomerDto> accountsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<CustomerDto>() {
		});
		return accountsResponse;
	}

	@Override
	public List<CustomerDto> findAll() {
		log.info("RestTemplate - findAll() - URL");
		String url = "http://localhost:8091/customer/all";
		ResponseEntity<List<CustomerDto>> accountsResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CustomerDto>>() {
		});
		List<CustomerDto> lst = accountsResponse.getBody();
		return lst;
	}

	
}
