package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BankApplication2Application {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication2Application.class, args);
	}

}
