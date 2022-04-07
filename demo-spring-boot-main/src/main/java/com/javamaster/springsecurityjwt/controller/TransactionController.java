package com.javamaster.springsecurityjwt.controller;

import java.util.List;

import com.javamaster.springsecurityjwt.DTO.TransactionDTO;
import com.javamaster.springsecurityjwt.entity.Transaction;
import com.javamaster.springsecurityjwt.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService service;

    @GetMapping(value = "/get")
    public List<Transaction> getTransaction(@RequestParam(defaultValue = "empty") String from,
                                            @RequestParam(defaultValue = "empty") String to) {
        return service.listTransaction(from, to);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDTO transaction) {

        return ResponseEntity.ok(service.CreatebankMoney(transaction));
    }
}
