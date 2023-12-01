package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.FuelLog;
import com.halilkrkn.rentACar.service.dto.fuelLog.request.AddFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.request.UpdateFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.response.GetListFuelLogResponse;

import java.util.List;

public interface FuelLogService {
    void add(AddFuelLogRequest addFuelLogRequest);
    void update(Integer id, UpdateFuelLogRequest updateFuelLogRequest);
    void delete(Integer id);

    List<GetListFuelLogResponse> findByFuelLogFuelQuantity(Double fuelQuantity);

    List<FuelLog> findByFuelLogFuelType(String fuelType);
}
