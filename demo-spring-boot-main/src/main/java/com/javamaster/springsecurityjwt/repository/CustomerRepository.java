package com.javamaster.springsecurityjwt.repository;

import java.util.List;

import com.javamaster.springsecurityjwt.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	boolean existsByCustomerName(String customerName);

	boolean existsByIdentityNo(String identityNo);

	Customer findByCustomerName(String customerNumber);

	List<Customer> findAllByOrderByCustomerNameDesc();

	@Query("SELECT e FROM Customer e")
	Page<Customer> findCustomers(Pageable pageable, List<Customer> customerList);

}
