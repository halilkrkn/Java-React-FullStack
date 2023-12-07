package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.DamageReport;
import com.halilkrkn.rentACar.service.dto.damageReport.response.GetListDamageReportResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageReportRepository extends JpaRepository<DamageReport, Integer> {

    // Devired ile damageDescription'a göre filtreleme
    List<DamageReport> findByDamageDescription(String damageDescription);

    // JPQL ile
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.damageReport.response.GetListDamageReportResponse(d.reportId, d.estimatedRepairCost) FROM DamageReport d WHERE d.estimatedRepairCost = :estimatedRepairCost")
    List<GetListDamageReportResponse> findByEstimatedRepairCost(Double estimatedRepairCost);

    boolean existsByReportId(Integer reportId);
    boolean existsByDamageDescription(String damageDescription);
}

