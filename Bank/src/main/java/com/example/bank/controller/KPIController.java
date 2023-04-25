package com.example.bank.controller;

import com.example.bank.models.KPI;
import com.example.bank.repositories.KPIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/kpi")
@RestController
public class KPIController {

    private final KPIRepository kpiRepository;

    @RequestMapping("/all")
    public List<KPI> getAllKPI() {
        return kpiRepository.findAll();
    }

    @RequestMapping("/add/{credit}")
    public String addNewKPI(@PathVariable int credit) {
        kpiRepository.save(new KPI(null, credit));
        return "KPI" + credit + " saved";
    }
}
