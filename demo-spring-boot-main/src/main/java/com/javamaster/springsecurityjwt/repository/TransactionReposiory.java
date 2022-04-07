package com.javamaster.springsecurityjwt.repository;

import java.time.LocalDate;
import java.util.List;

import com.javamaster.springsecurityjwt.DTO.TransactionDTO;
import com.javamaster.springsecurityjwt.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionReposiory extends JpaRepository<Transaction, Long> {

	void save(TransactionDTO transaction);

	List<Transaction> findAllByOrderByTransactionDateDesc();

	@Query("SELECT u FROM Transaction u WHERE u.transactionDate between ?1 and  ?2 ORDER BY u.transactionDate DESC")
	List<Transaction> listTransaction(LocalDate from, LocalDate to);

}
