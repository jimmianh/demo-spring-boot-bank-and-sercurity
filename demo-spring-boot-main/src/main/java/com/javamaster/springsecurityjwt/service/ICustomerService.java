package com.javamaster.springsecurityjwt.service;

import java.util.List;

import com.javamaster.springsecurityjwt.DTO.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ICustomerService {

	List<Customer> getAllCustomers();
	
	Page<Customer> findCustomers(Pageable pageable, List<Customer> customerList);
	
	void deleteById(Long Id);

	Customer getCustomerById(Long id);

	ResponseDTO updateCustomer(Customer customer);

	ResponseDTO createCustomer(Customer customer);

	
}
