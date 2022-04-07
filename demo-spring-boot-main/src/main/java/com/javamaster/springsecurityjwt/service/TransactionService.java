package com.javamaster.springsecurityjwt.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import com.javamaster.springsecurityjwt.Constant.Constant;
import com.javamaster.springsecurityjwt.DTO.TransactionDTO;
import com.javamaster.springsecurityjwt.entity.Account;
import com.javamaster.springsecurityjwt.entity.Transaction;
import com.javamaster.springsecurityjwt.repository.AccountRepository;
import com.javamaster.springsecurityjwt.repository.TransactionReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionReposiory repository;

	@Autowired
	private AccountRepository accRepo;

	@Override
	public void deleteTransactionById(Long id) {

		repository.deleteById(id);
	}

	@Override
	public List<Transaction> listTransaction(String from, String to) {
		LocalDate localDatefrom = null;
		LocalDate localDateto = null;
		String fromdate = from.replace("-", "/");
		String todate = to.replace("-", "/");

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		if (from != null && !from.isEmpty()) {
			localDatefrom = LocalDate.parse(fromdate);
		}
		if (to != null && !to.isEmpty()) {
			localDateto = LocalDate.parse(todate);
		}
		return repository.listTransaction(localDatefrom, localDateto);
	}

	@Override
	public List<Transaction> findAllByOrderByTransactionDateDesc(String accountNumber) {
		// truyền vào accountNumbercần tìm kiếm
		String message = "";
		try {
			if (!accRepo.existsByAccountNumber(accountNumber)) {

				message += "accountNumber not exists!";
			} else {
				Transaction transaction = null;
				transaction.setTransactionDate(transaction.getTransactionDate());

				repository.findAllByOrderByTransactionDateDesc();
			}
		} catch (Exception e) {
			message += e.getMessage();
		}

		return null;
	}

	@Override
	public Transaction CreatebankMoney(TransactionDTO formtransaction) {

		Account fromAccount = accRepo.findById(formtransaction.getFromAccount()).orElse(null);
		Account toAccount = accRepo.findById(formtransaction.getToAccount()).orElse(null);

		Transaction transaction = new Transaction();

		transaction.setAmount(formtransaction.getAmount());
		transaction.setContent(formtransaction.getContent());
		transaction.setFromAccount(fromAccount);
		transaction.setToAccuont(toAccount);
//
		if (fromAccount.getStatus() == Constant.ACCOUNT_STATUS_HET_HIEU_LUC
				|| toAccount.getStatus() == Constant.ACCOUNT_STATUS_HET_HIEU_LUC) {
			transaction.setErrorReason("Error:fromAccount or toAccount is expire, please checked!");
			transaction.setStatus(Constant.ACCOUNT_STATUS_HET_HIEU_LUC);
		}
		if (fromAccount.getBalance() < (formtransaction.getToAccount())) {
			transaction.setErrorReason("fromAccount insufficient balance! plesae recharge monney!");
			transaction.setStatus(Constant.TRANSACTION_STATUS_FAIL);
		}
		fromAccount.setBalance(fromAccount.getBalance() - formtransaction.getAmount());
		toAccount.setBalance(toAccount.getBalance() + formtransaction.getAmount());
		transaction.setErrorReason("SUCCESS");
		transaction.setStatus(Constant.TRANSACTION_STATUS_SUCCESS);
		return repository.save(transaction);
	}

}
