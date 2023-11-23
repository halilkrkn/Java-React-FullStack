package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.fuelLog.AddFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.UpdateFuelLogRequest;

public interface FuelLogService {
    void add(AddFuelLogRequest addFuelLogRequest);
    void update(Integer id, UpdateFuelLogRequest updateFuelLogRequest);
    void delete(Integer id);
}
