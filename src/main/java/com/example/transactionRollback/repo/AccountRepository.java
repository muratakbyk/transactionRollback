package com.example.transactionRollback.repo;

import com.example.transactionRollback.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

  public Account getAccountById(long id);
}
