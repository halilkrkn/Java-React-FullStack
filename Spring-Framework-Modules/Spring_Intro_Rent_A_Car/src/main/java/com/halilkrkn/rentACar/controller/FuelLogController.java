package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.FuelLog;
import com.halilkrkn.rentACar.repository.FuelLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuellogs")
public class FuelLogController {

    @Autowired
    private FuelLogRepository fuelLogRepository;

    @GetMapping
    public List<FuelLog> getAllFuelLogs() {
        return fuelLogRepository.findAll();
    }

    @GetMapping("/{id}")
    public FuelLog getFuelLogById(@PathVariable Integer id) {
        return fuelLogRepository.findById(id).orElse(null);
    }

    @PostMapping
    public FuelLog createFuelLog(@RequestBody FuelLog fuelLog) {
        return fuelLogRepository.save(fuelLog);
    }

    @PutMapping("/{id}")
    public FuelLog updateFuelLog(@PathVariable Integer id, @RequestBody FuelLog fuelLog) {
        FuelLog existingFuelLog = fuelLogRepository.findById(id).orElse(null);
        if (existingFuelLog == null) {
            return null;
        }

        existingFuelLog.setFuelType(fuelLog.getFuelType());
        existingFuelLog.setFuelQuantity(fuelLog.getFuelQuantity());
        existingFuelLog.setFuelCost(fuelLog.getFuelCost());
        existingFuelLog.setDateRecorded(fuelLog.getDateRecorded());
        existingFuelLog.setVehicle(fuelLog.getVehicle());
        existingFuelLog.setRental(fuelLog.getRental());

        return fuelLogRepository.save(existingFuelLog);
    }

    @DeleteMapping("/{id}")
    public void deleteFuelLog(@PathVariable Integer id) {
        fuelLogRepository.deleteById(id);
    }
}

