package com.crudoperation.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crudoperation.app.dto.CustomerSaveRequestDto;
import com.crudoperation.app.dto.CustomerSaveResponseDto;
import com.crudoperation.app.dto.CustomerUpdateRequestDto;
import com.crudoperation.app.entity.Customer;
import com.crudoperation.app.repository.CustomerRepository;
import com.crudoperation.app.service.CustomerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	@Override
	public CustomerSaveResponseDto saveCustomer(CustomerSaveRequestDto customerSaveRequestDto) {

		Customer customerEntity = new Customer();
		customerEntity.setFirstName(customerSaveRequestDto.getFirstName());
		customerEntity.setLastName(customerSaveRequestDto.getLastName());
		customerEntity.setGender(customerSaveRequestDto.getGender());
		customerEntity.setGmail(customerSaveRequestDto.getGmail());
		customerEntity.setMobile(customerSaveRequestDto.getMobile());

		this.customerRepository.save(customerEntity);

		CustomerSaveResponseDto customerSaveResponseDto = new CustomerSaveResponseDto();
		customerSaveResponseDto.setCustomerId(customerEntity.getCustomerId());
		customerSaveResponseDto.setFirstName(customerEntity.getFirstName());
		customerSaveResponseDto.setLastName(customerEntity.getLastName());
		customerSaveResponseDto.setGender(customerEntity.getGender());
		customerSaveResponseDto.setGmail(customerEntity.getGmail());
		customerSaveResponseDto.setMobile(customerEntity.getMobile());
		return customerSaveResponseDto;

	}

	@Override
	public List<CustomerSaveResponseDto> getAllCustomers() {
		List<CustomerSaveResponseDto> customerSaveResponseDtos = new ArrayList<>();
		Iterable<Customer> customerIterable = this.customerRepository.findAll();

		for (Customer customer : customerIterable) {

			CustomerSaveResponseDto dto = new CustomerSaveResponseDto();
			dto.setCustomerId(customer.getCustomerId());
			dto.setFirstName(customer.getFirstName());
			dto.setLastName(customer.getLastName());
			dto.setGender(customer.getGender());
			dto.setGmail(customer.getGmail());
			dto.setMobile(customer.getMobile());

			customerSaveResponseDtos.add(dto);

		}
		return customerSaveResponseDtos;
	}

	@Override
	public void updateCustomer(Long customerId, CustomerUpdateRequestDto customerUpdateRequestDto) {

		Optional<Customer> optionalCustomer = this.customerRepository.findById(customerId);
		
		
	

		if (optionalCustomer.isPresent()) {
			
			Customer entity = optionalCustomer.get();
			
			entity.setFirstName(customerUpdateRequestDto.getFirstName());
			entity.setLastName(customerUpdateRequestDto.getLastName());
			entity.setMobile(customerUpdateRequestDto.getMobile());
			
			this.customerRepository.save(entity);
			
			

		}

	}

}
