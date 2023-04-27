package com.example.bank.controller;

import com.example.bank.models.Customer;
import com.example.bank.models.KPI;
import com.example.bank.repositories.AccountRepository;
import com.example.bank.repositories.CategoryRepository;
import com.example.bank.repositories.CustomerRepository;
import com.example.bank.repositories.KPIRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class CustomerController {


    private final KPIRepository repo;
    private final CustomerRepository kundRepo;
    private final AccountRepository kontoRepo;

    private final CategoryRepository katRepo;

//    CustomerController(KPIRepository repo, CustomerRepository kundRepo, CategoryRepository katRepo, AccountRepository kontoRepo){
//        this.repo=repo;
//        this.kundRepo=kundRepo;
//        this.katRepo=katRepo;
//        this.kontoRepo=kontoRepo;
//    }

    @RequestMapping("kunder")
    public List<Customer> getAllKunder() {
        return kundRepo.findAll();
    }

    @RequestMapping("kunder/add1")
    public String addKunder1(@RequestParam String namn, @RequestParam String ssn,
                             @RequestParam int cred) {
        KPI kpi = new KPI(cred);
        repo.save(kpi);
        kundRepo.save(new Customer(namn, ssn, kpi));
        return "kund " + namn + " added (1) ";
    }

    @RequestMapping("kunder/add0")
    public String addKunder(@RequestParam String namn, @RequestParam String ssn,
                            @RequestParam Long id) {
        KPI kpi = repo.findById(id).get();
        if (kpi != null) {
            kundRepo.save(new Customer(namn, ssn, kpi));
            return "kund " + namn + " added";
        }
        return "Ogiltigt id";
    }

    @RequestMapping("kunder/add2")
    public String addKunder2(@RequestParam String namn, @RequestParam String ssn,
                             @RequestParam int cred) {
        KPI kpi = new KPI(cred);
        kundRepo.save(new Customer(namn, ssn, kpi));
        return "kund " + namn + " added (2) ";
    }

    @RequestMapping("kunder/delete/{id}")
    public String deleteKund(@PathVariable Long id) {
        kundRepo.deleteById(id);
        return "kund " + id + " togs bort";
    }
}
