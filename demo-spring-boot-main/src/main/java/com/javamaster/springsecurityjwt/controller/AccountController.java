package com.javamaster.springsecurityjwt.controller;

import javax.validation.Valid;

import com.javamaster.springsecurityjwt.entity.Account;
import com.javamaster.springsecurityjwt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	IAccountService accService;

	@GetMapping("/list-account")
	public ResponseEntity<?> getAllAccounts() {

		return new ResponseEntity<>(accService.getAllAccounts(), HttpStatus.OK);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountByID(@PathVariable(name = "id") Long id) {

		return new ResponseEntity<Account>(accService.getAccountById(id), HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@RequestBody Account account) {

		return ResponseEntity.ok(accService.createAccount(account));
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody @Valid Account account) {
		return ResponseEntity.ok(accService.updateAccount(account));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Long id) {
		accService.deleteById(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
