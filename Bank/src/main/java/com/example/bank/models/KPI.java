package com.example.bank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KPI {

    @Id
    @GeneratedValue
    private Long Id;
    private int credit;

    public KPI(int credit){
        this.credit=credit;
    }


}