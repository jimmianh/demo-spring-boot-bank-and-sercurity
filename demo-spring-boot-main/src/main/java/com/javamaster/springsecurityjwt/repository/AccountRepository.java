package com.javamaster.springsecurityjwt.repository;

import java.util.List;

import com.javamaster.springsecurityjwt.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(String accountNumber);

	boolean existsByAccountNumber(String accountNumber);

	List<Account> findAllByCustomer(Long customerId);

	@Query("SELECT e FROM Account e")
	List<Account> findAll(Sort sort);

	@Query(value = "SELECT * FROM Account account", nativeQuery = true)
	Page<Account> getAllAccount(Pageable pageable);

	@Query(value = "SELECT account FROM Account account WHERE " + "account.status=1"
			+ "ORDER BY accountNumber", nativeQuery = true)
	List<Account> findAllAccountOderbyAccountNumber(Long customerId);

	@Query(value = "SELECT account FROM Account account WHERE " + "account.status !=1"
			+ "ORDER BY accountNumber", nativeQuery = true)
	List<Account> getAllAccountOderbyAccountNumber1(Long customerId);


	@Query("SELECT e FROM Account e ORDER BY e.status DESC")
	List<Account> findAll(Long customerId);

	
}
