package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.service.dto.vehicle.request.AddVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.request.UpdateVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;

import java.util.List;

public interface VehicleService {
    void add(AddVehicleRequest addVehicleRequest);
    void update(Integer id, UpdateVehicleRequest updateVehicleRequest);
    void delete(Integer id);
    List<GetListVehicleResponse> findByPlateNumber(String plateNumber);
    List<Vehicle> findByBrand(String brand);
    Vehicle findById(Integer id);
}
