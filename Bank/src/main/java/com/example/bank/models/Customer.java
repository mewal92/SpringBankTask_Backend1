package com.example.bank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private Long Id;
    private String name;
    private String ssn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn               //FK-kolumn kommer, i default-fallet, att heta kpi_id
    //@JoinColumn(name="myFK", referencedColumnName="kreditvardighet")
    private KPI kpi;

    public Customer(String name, String ssn, KPI kpi){
        this.name=name;
        this.ssn=ssn;
        this.kpi = kpi;
    }

    ObjectMapper objectMapper = new ObjectMapper();


    //Nedanstående hör till N-1-filmen
    @ManyToOne
    @JoinColumn
    @JsonIgnore                               //Denna rad hör till 1-N-filmen
    private Category category;

    public Customer(String name, String ssn, KPI kpi, Category category){
        this.name=name;
        this.ssn=ssn;
        this.kpi = kpi;
        this.category = category;
    }

    //Nedanstående hör till N-M-filmen
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Account> account = new ArrayList<>();

    public void addKonto(Account k){
        account.add(k);
    }

}