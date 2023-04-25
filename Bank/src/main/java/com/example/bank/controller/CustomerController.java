package com.example.bank.controller;

import com.example.bank.models.Account;
import com.example.bank.models.Customer;
import com.example.bank.repositories.AccountRepository;
import com.example.bank.repositories.CustomerRepository;
import com.example.bank.repositories.KPIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final KPIRepository kpiRepository;
    private final AccountRepository accountRepository;

    @GetMapping ("/all")
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @RequestMapping("/add/{id}")
    public String addNewCustomer(@RequestBody Customer customer,
                            @PathVariable Long id) {
        customer.setKpi(kpiRepository.findById(id).get());
        customerRepository.save(customer);
        return "Customer" + customer + " saved";
    }

    @RequestMapping("/addKonto/{id}/{balance}/{interest}")
    public String addKonto(@PathVariable Long id, @PathVariable double balance,
                           @PathVariable double interest){
        Customer kund = customerRepository.findById(id).get();
        if (kund != null){
            kund.addAccount(new Account(balance, interest));
            customerRepository.save(kund);
        }
        return "konto lades till hos kund med id "+ id;
    }
}
