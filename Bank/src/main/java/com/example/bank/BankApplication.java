package com.example.bank;

import com.example.bank.models.Category;
import com.example.bank.models.Customer;
import com.example.bank.models.KPI;
import com.example.bank.repositories.CategoryRepository;
import com.example.bank.repositories.CustomerRepository;
import com.example.bank.repositories.KPIRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);


    }

//    @Bean
//    public CommandLineRunner demo(KPIRepository kpiRepository, CustomerRepository customerRepository,
//                                  CategoryRepository categoryRepository) {
//        return (args) -> {
//            KPI k1 = new KPI(45);
//            KPI k2 = new KPI(76);
//            KPI k3 = new KPI(3);
//            Category kat1 = new Category("guld");
//            Category kat2 = new Category("silver");
//            Category kat3 = new Category("brons");
//            //Vill inte cascada kategorierna pga N-1, och pga "on delete cascade" inte önskvärt beteende
//            categoryRepository.save(kat1);
//            categoryRepository.save(kat2);
//            categoryRepository.save(kat3);
//            Customer kund1 = new Customer("Mimmi", "435255", k1, kat1);
//            Customer kund2 = new Customer("Börje", "435255", k2, kat1);
//            Customer kund3 = new Customer("Elvis", "435255", k3, kat3);
//            customerRepository.save(kund1);
//            customerRepository.save(kund2);
//            customerRepository.save(kund3);
//        };
//    }
}