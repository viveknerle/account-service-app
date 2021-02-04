package com.microdemo.account.repository;

import com.microdemo.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

  @Query("FROM Account a")
  List<Account> getAllAccounts();

  @Query("SELECT a FROM Account a WHERE a.id = :id")
  Optional<Account> findById(@Param("id") String id);

  @Query("FROM Account a  WHERE a.customerId = :id")
  List<Account> getCustomerAllAccounts(@Param("id") String customerId);
}