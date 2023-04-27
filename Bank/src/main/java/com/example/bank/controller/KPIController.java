package com.example.bank.controller;

import com.example.bank.models.KPI;
import com.example.bank.repositories.KPIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class KPIController {

    private final KPIRepository kpiRepository;

    KPIController(KPIRepository kpiRepository){
        this.kpiRepository=kpiRepository;
    }

    @RequestMapping("kpis")
    public List<KPI> getAllKPIs(){
        return kpiRepository.findAll();
    }

    @RequestMapping("kpi/add")
    public String addKPIs(@RequestParam int cred){
        kpiRepository.save(new KPI(cred));
        return "kpi "+cred+" added";
    }


}
