package com.crudoperation.app.dto;

import com.crudoperation.app.constants.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CustomerSaveResponseDto {
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private String mobile;
	private Gender gender;
	private String gmail;


}
