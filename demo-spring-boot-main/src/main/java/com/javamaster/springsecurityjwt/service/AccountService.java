package com.javamaster.springsecurityjwt.service;

import java.util.List;

import javax.transaction.Transactional;

import com.javamaster.springsecurityjwt.DTO.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.Account;
import com.javamaster.springsecurityjwt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account findByAccountNumber(String accountNumber) {

		return accountRepo.findByAccountNumber(accountNumber);
	}

	@Override
	public List<Account> getAllAccounts() {

		return accountRepo.findAll();
	}

	@Override
	public List<Account> findAllByCustomer(Long customerId) {

		return accountRepo.findAllByCustomer(customerId);
	}

	@Override
	public List<Account> findAll(Sort sort) {

		return accountRepo.findAll(sort);
	}

	@Override
	public List<Account> findAllAccountOderbyAccountNumber(Long customerId) {

		return accountRepo.findAllAccountOderbyAccountNumber(customerId);
	}

	@Override
	public List<Account> getAllAccountOderbyAccountNumber1(Long customerId) {

		return accountRepo.getAllAccountOderbyAccountNumber1(customerId);
	}

	@Override
	public Page<Account> getAllAccounts(Pageable pageable) {

		Sort sort = Sort.by("customer").descending();
		Pageable pageable1 = PageRequest.of(1, 5, sort);

		return accountRepo.findAll(pageable1);
	}

	@Override
	public ResponseDTO createAccount(Account account) {
		ResponseDTO respo = new ResponseDTO();
		String massage = "accountNumber is exists! or accountNumber small 9";
		if (accountRepo.existsByAccountNumber(account.getAccountNumber()) || account.getAccountNumber().length() < 9) {
			respo.setCode("error");
			respo.setMassage(massage);
			return respo;
		} else {

			account = accountRepo.save(account);
			respo.setCode("success");
			respo.setMassage("create successfully!");
			respo.setData(account);
			return respo;
		}
	}

	@Override
	public ResponseDTO updateAccount(Account account) {
		ResponseDTO respo = new ResponseDTO();
		if (accountRepo.findById(account.getAccountId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage("Id is not exstis");
			return respo;
		}
		account.setAccountNumber(account.getAccountNumber());
		account.setBalance(account.getBalance());
		account.setStatus(account.getStatus());
		respo.setCode("succses");
		respo.setMassage("Update succsesfully!");
		respo.setData(respo);

		return respo;
	}

	@Override
	public void deleteById(Long Id) {

		accountRepo.deleteById(Id);
	}

	@Override
	public Account getAccountById(Long id) {

		return accountRepo.findById(id).get();
	}

	@Override
	public List<Account> findAll(Long customerId) {

		return accountRepo.findAll();
	}

}
