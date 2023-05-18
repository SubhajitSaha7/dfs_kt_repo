package com.cg.bankapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cg.bankapp.dto.BankAccountDto;
import com.cg.bankapp.vo.BankAccountVo;

@Mapper(componentModel = "spring")
public interface BankMapper {
	
	BankMapper bankmapper = Mappers.getMapper(BankMapper.class);	
	BankAccountVo dtoToVo(BankAccountDto dto);
	
	BankAccountDto voToDto(BankAccountVo bvo);
	
}
