package com.crudoperation.app.service;

import java.util.List;

import com.crudoperation.app.dto.CustomerSaveRequestDto;
import com.crudoperation.app.dto.CustomerSaveResponseDto;
import com.crudoperation.app.dto.CustomerUpdateRequestDto;

public interface CustomerService {
	
	CustomerSaveResponseDto saveCustomer(CustomerSaveRequestDto customerSaveRequestDto);
	
	List<CustomerSaveResponseDto> getAllCustomers();
	
	void updateCustomer(Long customerId, CustomerUpdateRequestDto customerUpdateRequestDto);

}
