package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);
        if (existingVehicle == null) {
            return null;
        }

        existingVehicle.setBrand(vehicle.getBrand());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYears(vehicle.getYears());
        existingVehicle.setPlateNumber(vehicle.getPlateNumber());
        existingVehicle.setPrice(vehicle.getPrice());
        existingVehicle.setStatus(vehicle.getStatus());

        return vehicleRepository.save(existingVehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Integer id) {
        vehicleRepository.deleteById(id);
    }
}

