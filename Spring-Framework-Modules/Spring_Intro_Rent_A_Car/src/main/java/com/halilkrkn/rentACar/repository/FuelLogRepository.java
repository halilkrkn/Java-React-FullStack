package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.FuelLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelLogRepository extends JpaRepository<FuelLog, Integer> {

}

