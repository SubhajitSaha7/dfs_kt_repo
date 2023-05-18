package com.cg.bankapp2.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cg.bankapp2.dto.BankAccountDto;
import com.cg.bankapp2.util.Bank2Constants;

@FeignClient(value = "bankapp-api-fc", url = Bank2Constants.URL_BANKAPP)
public interface IFeignClient {
	
	@GetMapping("/accounts")
    List<BankAccountDto> findAllAccountsByFC();

    @GetMapping("/account/{id}")
    BankAccountDto findByIdByFC(@PathVariable("id") Integer id);
	
}
