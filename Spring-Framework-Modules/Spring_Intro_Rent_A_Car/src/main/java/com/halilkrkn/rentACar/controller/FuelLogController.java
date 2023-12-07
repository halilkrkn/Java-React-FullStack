package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.FuelLog;
import com.halilkrkn.rentACar.service.abstracts.FuelLogService;
import com.halilkrkn.rentACar.service.dto.fuelLog.request.AddFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.request.UpdateFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.response.GetListFuelLogResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuellogs")
@RequiredArgsConstructor
public class FuelLogController {

    private final FuelLogService fuelLogService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddFuelLogRequest fuelLog) {
        fuelLogService.add(fuelLog);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody @Valid UpdateFuelLogRequest fuelLog) {
        fuelLogService.update(id, fuelLog);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        fuelLogService.delete(id);
    }

    @GetMapping("/fuel-quantity")
    public List<GetListFuelLogResponse> findByFuelLogFuelQuantity(@RequestParam Double fuelQuantity) {
        return fuelLogService.findByFuelLogFuelQuantity(fuelQuantity);
    }

    @GetMapping("/fuel-type")
    public List<FuelLog> findByFuelLogFuelType(@RequestParam String fuelType) {
        return fuelLogService.findByFuelLogFuelType(fuelType);
    }
}

