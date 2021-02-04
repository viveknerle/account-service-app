package com.microdemo.account.service.impl;

import com.microdemo.account.entity.Account;
import com.microdemo.account.repository.AccountRepository;
import com.microdemo.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Transactional
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Account> fetchAllAccounts() {
    log.info("Fetching all accounts information.");
    return accountRepository.getAllAccounts();
  }

  @Override
  public Account fetchAccountById(String id) {
    log.info("Fetching account for id : {}", id);
    return accountRepository.getOne(id);
  }

  @Override
  public Account saveAccountInfo(Account account) {
    log.info("Save account information.");
    return accountRepository.save(account);
  }

  @Override
  public void deleteAccount(String id) {
    log.info("Delete account information for id : {}", id);
    accountRepository.deleteById(id);
  }

  @Override
  public List<Account> getCustomerAllAccounts(String customerId) {
    log.info("Fetching all customer accounts information.");
    return accountRepository.getCustomerAllAccounts(customerId);
  }

}