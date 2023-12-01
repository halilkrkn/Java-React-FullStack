package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.vehicle.request.AddVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.request.UpdateVehicleRequest;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/plateNumber")
    public List<GetListVehicleResponse> findByPlateNumber(@RequestParam String plateNumber) {
      return vehicleService.findByPlateNumber(plateNumber);
    }

    @GetMapping("/brand")
    public List<Vehicle> findByBrand(@RequestParam String brand) {
      return vehicleService.findByBrand(brand);
    }
}

