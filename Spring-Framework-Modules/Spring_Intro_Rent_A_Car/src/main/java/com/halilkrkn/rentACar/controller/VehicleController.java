package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.vehicle.AddVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.UpdateVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/add")
    public void add(@RequestBody AddVehicleRequest vehicle) {
        vehicleService.add(vehicle);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateVehicleRequest vehicle) {
        vehicleService.update(id, vehicle);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        vehicleService.delete(id);
    }
}

