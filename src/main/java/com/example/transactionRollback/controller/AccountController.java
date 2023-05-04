package com.example.transactionRollback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.transactionRollback.service.TransactionService;

@Controller
public class AccountController {

  @Autowired
  TransactionService transactionService;

  @PostMapping("/moneyTransfer")
  public void moneyTransfer(@RequestParam double transferAmount, @RequestParam long myAccId, @RequestParam long receiverAccId){
    transactionService.moneyTransfer(transferAmount,myAccId,receiverAccId);
  }

  @GetMapping("/getBalance")
  public ResponseEntity<String> getBalance(@RequestParam long accId){
    return new ResponseEntity(transactionService.getBalance(accId), HttpStatus.OK);
  }
}
