package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.FuelLog;
import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.FuelLogRepository;
import com.halilkrkn.rentACar.service.abstracts.FuelLogService;
import com.halilkrkn.rentACar.service.abstracts.RentalService;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.fuelLog.request.AddFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.request.UpdateFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.response.GetListFuelLogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FuelLogServiceImpl implements FuelLogService {

    private final FuelLogRepository fuelLogRepository;
    private final RentalService rentalService;
    private final VehicleService vehicleService;

    @Override
    public void add(AddFuelLogRequest addFuelLogRequest) {
        if (fuelLogRepository.existsByFuelType(addFuelLogRequest.getFuelType())) {
            throw new RuntimeException("Fuel type already exists");
        }
        FuelLog fuelLog = new FuelLog();
        fuelLog.setFuelType(addFuelLogRequest.getFuelType());
        fuelLog.setFuelQuantity(addFuelLogRequest.getFuelQuantity());
        fuelLog.setDateRecorded(addFuelLogRequest.getDateRecorded());
        fuelLog.setFuelCost(addFuelLogRequest.getFuelCost());
        Rental rentalId = rentalService.findById(addFuelLogRequest.getRentalId());
        fuelLog.setRental(rentalId);
        Vehicle vehicleId = vehicleService.findById(addFuelLogRequest.getVehicleId());
        fuelLog.setVehicle(vehicleId);

        fuelLogRepository.save(fuelLog);
    }

    @Override
    public void update(Integer id, UpdateFuelLogRequest updateFuelLogRequest) {
        if (!fuelLogRepository.existsByLogId(id)) {
            throw new RuntimeException("Fuel log not found");
        }
        FuelLog fuelLog = fuelLogRepository.findById(id).orElseThrow();
        fuelLog.setFuelType(updateFuelLogRequest.getFuelType());
        fuelLog.setFuelQuantity(updateFuelLogRequest.getFuelQuantity());
        fuelLog.setDateRecorded(updateFuelLogRequest.getDateRecorded());
        fuelLog.setFuelCost(updateFuelLogRequest.getFuelCost());
        Vehicle vehicleId = vehicleService.findById(updateFuelLogRequest.getVehicleId());
        fuelLog.setVehicle(vehicleId);
        Rental rentalId = rentalService.findById(updateFuelLogRequest.getRentalId());
        fuelLog.setRental(rentalId);

        fuelLogRepository.save(fuelLog);

    }

    @Override
    public void delete(Integer id) {
        fuelLogRepository.deleteById(id);
    }

    @Override
    public List<GetListFuelLogResponse> findByFuelLogFuelQuantity(Double fuelQuantity) {
        return fuelLogRepository.findByFuelQuantity(fuelQuantity)
                .stream()
                .map((fuelLog) -> new GetListFuelLogResponse(fuelLog.getLogId(), fuelLog.getFuelQuantity()))
                .toList();
    }

    @Override
    public List<FuelLog> findByFuelLogFuelType(String fuelType) {
        return fuelLogRepository.findByFuelType(fuelType);
    }

    @Override
    public FuelLog findById(Integer id) {
        return fuelLogRepository.findById(id).orElseThrow();
    }
}
