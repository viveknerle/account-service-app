package com.microdemo.account.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
public class Account {

  @Id
  private String id;
  private String accountType;
  private Date openDate;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "customer_id", updatable = false, nullable = false)
  private Customer customer;

  private String customerName;
  private String branch;
  private String minorIndicator;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Date getOpenDate() {
    return openDate;
  }

  public void setOpenDate(Date openDate) {
    this.openDate = openDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getMinorIndicator() {
    return minorIndicator;
  }

  public void setMinorIndicator(String minorIndicator) {
    this.minorIndicator = minorIndicator;
  }

}