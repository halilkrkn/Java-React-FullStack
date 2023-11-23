package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.MaintenanceRecordService;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.AddMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.UpdateMaintenanceRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maintenancerecords")
@RequiredArgsConstructor
public class MaintenanceRecordController {

    private final MaintenanceRecordService maintenanceRecordService;

    @PostMapping("/add")
    public void add(@RequestBody AddMaintenanceRecordRequest maintenanceRecord) {
        maintenanceRecordService.add(maintenanceRecord);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateMaintenanceRecordRequest maintenanceRecord) {
        maintenanceRecordService.update(id, maintenanceRecord);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        maintenanceRecordService.delete(id);
    }
}

