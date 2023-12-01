package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.MaintenanceRecord;
import com.halilkrkn.rentACar.service.abstracts.MaintenanceRecordService;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.request.AddMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.request.UpdateMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.response.GetListMaintenanceRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/maintenance-type")
    public List<MaintenanceRecord> findByMaintenanceRecordMaintenanceType(@RequestParam String maintenanceType) {
        return maintenanceRecordService.findByMaintenanceType(maintenanceType);
    }

    @GetMapping("/maintenance-cost")
    public List<GetListMaintenanceRecordResponse> findByMaintenanceRecordMaintenanceCost(@RequestParam Double maintenanceCost) {
        return maintenanceRecordService.findByMaintenanceRecordMaintenanceCost(maintenanceCost);
    }
}

