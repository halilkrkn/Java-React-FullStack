package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.vehicle.AddVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.UpdateVehicleRequest;

public interface VehicleService {
    void add(AddVehicleRequest addVehicleRequest);
    void update(Integer id, UpdateVehicleRequest updateVehicleRequest);
    void delete(Integer id);
}
