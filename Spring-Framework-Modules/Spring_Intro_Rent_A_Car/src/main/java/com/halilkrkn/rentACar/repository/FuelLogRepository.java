package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.FuelLog;
import com.halilkrkn.rentACar.service.dto.fuelLog.response.GetListFuelLogResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelLogRepository extends JpaRepository<FuelLog, Integer> {

    // Devired ile fuelType'a göre filtreleme
    List<FuelLog> findByFuelType(String fuelType);

    // JPQL ile fuelQuantity'a göre filtreleme
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.fuelLog.response.GetListFuelLogResponse(f.logId, f.fuelType, f.fuelQuantity) FROM FuelLog f WHERE f.fuelQuantity = :fuelQuantity")
    List<GetListFuelLogResponse> findByFuelQuantity(Double fuelQuantity);

    boolean existsByLogId(Integer logId);
    boolean existsByFuelType(String fuelType);


}

