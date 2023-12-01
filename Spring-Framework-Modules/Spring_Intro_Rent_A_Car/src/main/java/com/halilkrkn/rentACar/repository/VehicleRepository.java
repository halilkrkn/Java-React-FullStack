package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    // Devired ile Vehicle tablosundan brand alanına göre sorgu yapılıyor.
    List<Vehicle> findByBrand(String brand);

    // JPQL ile plateNumber alanına göre sorgu yapılıyor.
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse(v.vehicleId, v.brand, v.model, v.years, v.plateNumber, v.price, v.status) FROM Vehicle v WHERE v.plateNumber = :plateNumber")
    List<GetListVehicleResponse> findByPlateNumber(String plateNumber);
}

