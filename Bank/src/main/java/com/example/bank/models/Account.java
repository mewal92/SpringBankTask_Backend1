package com.example.bank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private Double balance;
    private Double interest;

//    @ManyToMany(mappedBy = "account")
//    List<Customer> customer;

    public Account(Double balance,Double interest ){
        this.balance = balance;
        this.interest = interest;
    }
}
