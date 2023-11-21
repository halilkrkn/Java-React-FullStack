package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.DamageReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageReportRepository extends JpaRepository<DamageReport, Integer> {
}

