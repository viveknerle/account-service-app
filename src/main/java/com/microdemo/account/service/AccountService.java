package com.microdemo.account.service;

import com.microdemo.account.entity.Account;

import java.util.List;

public interface AccountService {

  List<Account> fetchAllAccounts();

  Account fetchAccountById(String id);

  Account saveAccountInfo(Account account);

  void deleteAccount(String id);

  List<Account> getCustomerAllAccounts(String customerId);
}