package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.FuelLog;
import com.halilkrkn.rentACar.repository.FuelLogRepository;
import com.halilkrkn.rentACar.service.abstracts.FuelLogService;
import com.halilkrkn.rentACar.service.dto.fuelLog.AddFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.UpdateFuelLogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FuelLogServiceImpl implements FuelLogService {

    private final FuelLogRepository fuelLogRepository;

    @Override
    public void add(AddFuelLogRequest addFuelLogRequest) {
        FuelLog fuelLog = new FuelLog();
        fuelLog.setFuelType(addFuelLogRequest.getFuelType());
        fuelLog.setFuelQuantity(addFuelLogRequest.getFuelQuantity());
        fuelLog.setDateRecorded(addFuelLogRequest.getDateRecorded());
        fuelLog.setFuelCost(addFuelLogRequest.getFuelCost());
        fuelLog.setVehicle(addFuelLogRequest.getVehicle());
        fuelLog.setRental(addFuelLogRequest.getRental());

        fuelLogRepository.save(fuelLog);
    }

    @Override
    public void update(Integer id, UpdateFuelLogRequest updateFuelLogRequest) {

        FuelLog fuelLog = fuelLogRepository.findById(id).orElseThrow();
        fuelLog.setFuelType(updateFuelLogRequest.getFuelType());
        fuelLog.setFuelQuantity(updateFuelLogRequest.getFuelQuantity());
        fuelLog.setDateRecorded(updateFuelLogRequest.getDateRecorded());
        fuelLog.setFuelCost(updateFuelLogRequest.getFuelCost());
        fuelLog.setVehicle(updateFuelLogRequest.getVehicle());
        fuelLog.setRental(updateFuelLogRequest.getRental());

        fuelLogRepository.save(fuelLog);

    }

    @Override
    public void delete(Integer id) {
        fuelLogRepository.deleteById(id);
    }
}
