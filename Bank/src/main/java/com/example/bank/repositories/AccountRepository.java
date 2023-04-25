package com.example.bank.repositories;

import com.example.bank.models.Account;
import com.example.bank.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
