package com.javamaster.springsecurityjwt.controller;

import java.util.List;

import javax.validation.Valid;

import com.javamaster.springsecurityjwt.entity.Customer;
import com.javamaster.springsecurityjwt.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService cusService;

    @GetMapping("/list- customer")
    public ResponseEntity<?> getAllCustomer(Pageable pageable, List<Customer> customerList) {

        return new ResponseEntity<>(cusService.findCustomers(pageable, customerList), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCustomerByID(@PathVariable(name = "id") Long id) {

        return new ResponseEntity<Customer>(cusService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {

        return ResponseEntity.ok(cusService.createCustomer(customer));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateAccount(@RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(cusService.updateCustomer(customer));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") Long id) {
        cusService.deleteById(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }

}
