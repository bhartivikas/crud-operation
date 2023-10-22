package com.crudoperation.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperation.app.dto.ApiResponseDto;
import com.crudoperation.app.dto.CustomerSaveRequestDto;
import com.crudoperation.app.dto.CustomerSaveResponseDto;
import com.crudoperation.app.dto.CustomerUpdateRequestDto;
import com.crudoperation.app.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/customers")
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public ApiResponseDto<CustomerSaveResponseDto> saveCustomerInfo(
			@RequestBody CustomerSaveRequestDto customerSaveRequestDto) {

		CustomerSaveResponseDto customerSaveResponseDto = this.customerService.saveCustomer(customerSaveRequestDto);
		ApiResponseDto<CustomerSaveResponseDto> apiResponseDto = new ApiResponseDto<>();
		apiResponseDto.setMessage("Customer data saved successfully");
		apiResponseDto.setResponse(customerSaveResponseDto);
		return apiResponseDto;

	}

	@GetMapping
	public ApiResponseDto<List<CustomerSaveResponseDto>> getAllCustomer() {
		List<CustomerSaveResponseDto> customers = this.customerService.getAllCustomers();

		ApiResponseDto<List<CustomerSaveResponseDto>> apiResponseDto = new ApiResponseDto<>();
		apiResponseDto.setMessage("All customers details fetched successfully");
		apiResponseDto.setResponse(customers);
		return apiResponseDto;

	}

	@PutMapping("/{customerId}")
	public ApiResponseDto<String> updateCustomerInfo(@PathVariable Long customerId,
			@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) {

		this.customerService.updateCustomer(customerId, customerUpdateRequestDto);

		ApiResponseDto<String> apiResponseDto = new ApiResponseDto<>();
		apiResponseDto.setMessage("Customer updated successfully");
		return apiResponseDto;
	}

}
