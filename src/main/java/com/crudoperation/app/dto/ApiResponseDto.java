package com.crudoperation.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDto<T> {
	
	private T response;
	private String message;

}
