package com.javamaster.springsecurityjwt.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.javamaster.springsecurityjwt.DTO.ResponseDTO;
import com.javamaster.springsecurityjwt.entity.Customer;
import com.javamaster.springsecurityjwt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CustomerService implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	// lấy ra danh sách Customer được sắp xếp theo trường customerName theo
	// thứ tự alphab giảm dần! áp dụng hỗ trợ của JpaRepository
	@Override
	public List<Customer> getAllCustomers() {

		return customerRepo.findAllByOrderByCustomerNameDesc();
	}

	@Override
	public Page<Customer> findCustomers(Pageable pageable, List<Customer> customerList) {
//		List<Customer> customerList1 = new ArrayList<>();
		customerList.stream().sorted(Comparator.comparing(Customer::getCustomerName).reversed())
				.collect(Collectors.toList());
		return customerRepo.findCustomers(pageable, customerList);
	}

	@Override
	public ResponseDTO createCustomer(Customer customer) {
		ResponseDTO respo = new ResponseDTO();
		if (customerRepo.existsByCustomerName(customer.getCustomerName())) {
			respo.setCode("error");
			respo.setMassage("customerName is exists");
			return respo;
		}
		if (customerRepo.existsByIdentityNo(customer.getIdentityNo())) {
			respo.setCode("error");
			respo.setMassage("identityNo is exist");
			return respo;
		}
		respo.setCode("success");
		respo.setMassage("create successfully!");
		respo.setData(customer);

		return respo;
	}

	@Override
	public ResponseDTO updateCustomer(Customer customer) {
		ResponseDTO respo = new ResponseDTO();
		if (customerRepo.findById(customer.getCustomerId()).equals(null)) {
			respo.setCode("error");
			respo.setMassage("Id is not exists");
			return respo;
		}
		customer.setCustomerName(customer.getCustomerName());
		customer.setAddress(customer.getAddress());
		customer.setCustomertype(customer.getCustomertype());
		customer.setIdentityNo(customer.getIdentityNo());
		customer.setStatus(customer.getStatus());
		respo.setCode("success");
		respo.setMassage("create successfully!");
		respo.setData(customer);
		return respo;
	}

	@Override
	public void deleteById(Long Id) {

		customerRepo.deleteById(Id);

	}

	@Override
	public Customer getCustomerById(Long id) {

		return customerRepo.findById(id).get();
	}

}
