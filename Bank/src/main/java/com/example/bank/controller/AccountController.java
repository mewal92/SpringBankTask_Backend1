package com.example.bank.controller;
import com.example.bank.models.Account;
import com.example.bank.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/account")
@RestController

public class AccountController {
    private final AccountRepository accountRepository;

    @PutMapping("/accounts/{id}")
    public void updateAccount(@PathVariable long id,
                              @RequestParam(required = false) Double balance,
                              @RequestParam(required = false) Double interest) {
        // lookup the account by ID here
        Account account = accountRepository.findById(id).get();

        // update the balance if specified
        if (balance != null) {
            account.setBalance(balance);
        }

        // update the interest if specified
        if (interest != null) {
            account.setInterest(interest);
        }

        // save the updated account here
        accountRepository.save(account);
    }
}
