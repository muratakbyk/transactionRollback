package com.example.transactionRollback.service;

import com.example.transactionRollback.model.Account;
import com.example.transactionRollback.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  AccountRepository accountRepository;
  private static final Logger logger = Logger.getLogger(TransactionServiceImpl.class.getName());
  Account myAcc;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void moneyTransfer(double transferAmount, long myAccId, long recipientAccId)  {
    myAcc = accountRepository.getAccountById(myAccId);

    if(myAcc.getBalance() >= transferAmount){
        logger.info("My initial balance: " + myAcc.getBalance());
        myAcc.setBalance(myAcc.getBalance() - transferAmount);
        // Decreasing my current balance

        accountRepository.save(myAcc);
        // Saving my new balance to the Database

        logger.info("My new balance: " + accountRepository.getAccountById(myAccId).getBalance());
        Account recipient = accountRepository.findById(recipientAccId).get();
        // Since there is no recipient Account an exception will occur here
    }
  }

  @Override
  public String getBalance(long accId) {
    Account acc = accountRepository.findById(accId).get();
    String balance = String.valueOf(acc.getBalance());
    logger.info("My balance after transaction roll back: " +
      accountRepository.getAccountById(accId).getBalance());
    return balance;
  }
}
