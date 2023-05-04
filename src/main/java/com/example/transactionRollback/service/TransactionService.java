package com.example.transactionRollback.service;

public interface TransactionService {

  public void moneyTransfer(double transferAmount, long myAccId, long receiverAccId);
  public String getBalance(long accId);
}
