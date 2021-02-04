package com.microdemo.account.service.impl;

import com.microdemo.account.client.CustomerServiceClient;
import com.microdemo.account.entity.Account;
import com.microdemo.account.entity.Customer;
import com.microdemo.account.repository.AccountRepository;
import com.microdemo.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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

  @Autowired
  private CustomerServiceClient customerServiceClient;

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
    account.setCustomer(customerServiceClient.createCustomer(account.getCustomer()));
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