package com.example.bank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
    private Long id;

    private Integer credit;

//    @OneToOne(mappedBy = "address")
//    private Customer customer;

}
