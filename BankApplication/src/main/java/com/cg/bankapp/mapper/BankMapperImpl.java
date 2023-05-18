package com.cg.bankapp.mapper;

import com.cg.bankapp.dto.BankAccountDto;
import com.cg.bankapp.vo.BankAccountVo;
import javax.annotation.processing.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-12T11:39:36+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class BankMapperImpl implements BankMapper {
	
	private static final Logger log = LoggerFactory.getLogger(BankMapperImpl.class);

    @Override
    public BankAccountVo dtoToVo(BankAccountDto dto) {
    	log.info("MapperIMPL - dtoToVo()");
        if ( dto == null ) {
            return null;
        }
        BankAccountVo bankAccountVo = new BankAccountVo();

        bankAccountVo.setCustId( dto.getCustId() );
        bankAccountVo.setAccountNumber( dto.getAccountNumber() );
        bankAccountVo.setIfscCode( dto.getIfscCode() );
        bankAccountVo.setCustomerName( dto.getCustomerName() );
        bankAccountVo.setPhoneNumber( dto.getPhoneNumber() );
        bankAccountVo.setCity( dto.getCity() );

        return bankAccountVo;
    }

    @Override
    public BankAccountDto voToDto(BankAccountVo bvo) {
    	log.info("MapperIMPL - voToDto()");
        if ( bvo == null ) {
            return null;
        }
        BankAccountDto bankAccountDto = new BankAccountDto();

        bankAccountDto.setCustId( bvo.getCustId() );
        bankAccountDto.setAccountNumber( bvo.getAccountNumber() );
        bankAccountDto.setIfscCode( bvo.getIfscCode() );
        bankAccountDto.setCustomerName( bvo.getCustomerName() );
        bankAccountDto.setPhoneNumber( bvo.getPhoneNumber() );
        bankAccountDto.setCity( bvo.getCity() );

        return bankAccountDto;
    }
}
