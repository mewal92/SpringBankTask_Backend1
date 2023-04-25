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
    /*@Bean
    public CommandLineRunner bank(KPIRepository kpiRepository, CustomerRepository customerRepository, CategoryRepository categoryRepository) {
        return (args) -> {
            KPI k1 = new KPI(null, 45);
            KPI k2 = new KPI(null, 102);
            KPI k3 = new KPI(null, 55);

          kpiRepository.save(k1);
          kpiRepository.save(k2);
         kpiRepository.save(k3);

            Category cat1 = new Category("Gigachad medlem");
            Category cat2 = new Category("Power ranger medlem");
            Category cat3 = new Category("Magikarp medlem");

            categoryRepository.save(cat1);
            categoryRepository.save(cat2);
            categoryRepository.save(cat3);

            Customer c1 = new Customer("Göran", "860327", k1, cat1);
            Customer c2 = new Customer("Märta", "341202", k2, cat2);
            Customer c3 = new Customer("Hassan", "021005", k3, cat3);

          c1.setCategory(cat1);
       c2.setCategory(cat2);
      c3.setCategory(cat3);

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
        };
    }*/
}
