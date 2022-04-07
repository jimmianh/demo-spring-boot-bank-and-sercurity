package com.javamaster.springsecurityjwt.service;


import com.javamaster.springsecurityjwt.DTO.TransactionDTO;
import com.javamaster.springsecurityjwt.entity.Transaction;

import java.util.List;

public interface ITransactionService {

	void deleteTransactionById(Long id);

	Transaction CreatebankMoney(TransactionDTO formtransaction);

	List<Transaction> findAllByOrderByTransactionDateDesc(String accountNumber);

	List<Transaction> listTransaction(String from, String to);

}
