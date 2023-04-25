package com.example.bank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private KPI kpi;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Category category;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable
    private List<Account> account = new ArrayList<>();

    public Customer(String name, String birthDate, KPI kpi) {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(String name, String birthDate, KPI kpi, Category category) {
        this.name = name;
        this.birthDate = birthDate;
        this.kpi = kpi;
        this.category = category;
    }

    public void addAccount(Account account){
        this.account.add(account);
    }
}
