package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.MaintenanceRecord;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.response.GetListMaintenanceRecordResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Integer> {

    // Devired ile maintenanceType'a göre filtreleme
    List<MaintenanceRecord> findByMaintenanceType(String maintenanceType);

    // JPQL ile maintenanceCost'a göre filtreleme
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.maintanenceRecord.response.GetListMaintenanceRecordResponse(m.recordId, m.maintenanceCost) FROM MaintenanceRecord m WHERE m.maintenanceCost = :maintenanceCost")
    List<GetListMaintenanceRecordResponse> findByMaintenanceCost(Double maintenanceCost);

    boolean existsByRecordId(Integer recordId);

    boolean existsByMaintenanceType(String maintenanceType);
}

