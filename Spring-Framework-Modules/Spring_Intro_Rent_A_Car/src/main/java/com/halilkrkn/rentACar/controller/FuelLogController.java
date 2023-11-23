package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.FuelLogService;
import com.halilkrkn.rentACar.service.dto.fuelLog.AddFuelLogRequest;
import com.halilkrkn.rentACar.service.dto.fuelLog.UpdateFuelLogRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fuellogs")
@RequiredArgsConstructor
public class FuelLogController {

    private final FuelLogService fuelLogService;

    @PostMapping("/add")
    public void add(@RequestBody AddFuelLogRequest fuelLog) {
        fuelLogService.add(fuelLog);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateFuelLogRequest fuelLog) {
        fuelLogService.update(id, fuelLog);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        fuelLogService.delete(id);
    }
}

