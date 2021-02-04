package com.microdemo.account.controller;

import com.microdemo.account.entity.Account;
import com.microdemo.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @GetMapping(value = "/")
  public ResponseEntity<Collection<Account>> getAllAccounts() {
    log.info("Fetch all account information.");
    List<Account> listAccounts = accountService.fetchAllAccounts();
    return new ResponseEntity<>(listAccounts, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Account> getAccount(@PathVariable("id") String accountId) {
    log.info("Fetch account information for id: {}", accountId);
    Account account = accountService.fetchAccountById(accountId);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<Account> updateAccount(@RequestBody final Account account) {
    log.info("Edit account information for id: {}", account.getId());
    Account savedAccount = accountService.saveAccountInfo(account);
    return new ResponseEntity<>(savedAccount, HttpStatus.OK);
  }

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") String accountId) {
    log.info("Delete account information for id: {}", accountId);
    accountService.deleteAccount(accountId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Account> createAccount(@RequestBody final Account account) {
    log.info("Create new account");
    Account savedAccount = accountService.saveAccountInfo(account);
    return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
  }

  @GetMapping(value = "/customer/{id}")
  public ResponseEntity<Collection<Account>> getCustomerAllAccounts(@PathVariable(name = "id") String customerId) {
    log.info("Fetch all account information.");
    List<Account> listAccounts = accountService.getCustomerAllAccounts(customerId);
    return new ResponseEntity<>(listAccounts, HttpStatus.OK);
  }
}