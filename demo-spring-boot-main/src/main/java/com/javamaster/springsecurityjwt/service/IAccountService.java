package com.javamaster.springsecurityjwt.service;

import java.util.List;

import com.javamaster.springsecurityjwt.DTO.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public interface IAccountService {

	Account findByAccountNumber(String accountNumber);

	List<Account> getAllAccounts();

	List<Account> findAllByCustomer(Long customerId);

	List<Account> findAll(Sort sort);

	Page<Account> getAllAccounts(Pageable pageable);

	List<Account> findAllAccountOderbyAccountNumber(Long customerId);

	List<Account> getAllAccountOderbyAccountNumber1(Long customerId);

	ResponseDTO createAccount(Account account);

	ResponseDTO updateAccount(Account account);

	void deleteById(Long Id);

	Account getAccountById(Long id);

	List<Account> findAll(Long customerId);
}
