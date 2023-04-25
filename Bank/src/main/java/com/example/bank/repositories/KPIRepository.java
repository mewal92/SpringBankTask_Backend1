package com.example.bank.repositories;

import com.example.bank.models.KPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KPIRepository extends JpaRepository<KPI, Long> {
}
