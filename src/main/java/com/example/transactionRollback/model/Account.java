package com.example.transactionRollback.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="ACCOUNT")
public class Account {
  @Id
  private Long id;

  @Column(name="balance")
  private double balance;

}
