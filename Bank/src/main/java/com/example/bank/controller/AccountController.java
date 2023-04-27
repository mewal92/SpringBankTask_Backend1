package com.example.bank.controller;
import com.example.bank.models.Account;
import com.example.bank.repositories.AccountRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    AccountController(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @RequestMapping("konton")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @RequestMapping("konton/delete/{id}")
    public String deleteAccount(@PathVariable Long id){
        accountRepository.deleteById(id);
        return "konto togs bort";
    }

}