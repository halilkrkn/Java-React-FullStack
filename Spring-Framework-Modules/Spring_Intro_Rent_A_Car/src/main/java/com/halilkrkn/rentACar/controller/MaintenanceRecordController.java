package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.MaintenanceRecord;
import com.halilkrkn.rentACar.repository.MaintenanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenancerecords")
public class MaintenanceRecordController {

    @Autowired
    private MaintenanceRecordRepository maintenanceRecordRepository;

    @GetMapping
    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return maintenanceRecordRepository.findAll();
    }

    @GetMapping("/{id}")
    public MaintenanceRecord getMaintenanceRecordById(@PathVariable Integer id) {
        return maintenanceRecordRepository.findById(id).orElse(null);
    }

    @PostMapping
    public MaintenanceRecord createMaintenanceRecord(@RequestBody MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordRepository.save(maintenanceRecord);
    }

    @PutMapping("/{id}")
    public MaintenanceRecord updateMaintenanceRecord(@PathVariable Integer id, @RequestBody MaintenanceRecord maintenanceRecord) {
        MaintenanceRecord existingMaintenanceRecord = maintenanceRecordRepository.findById(id).orElse(null);
        if (existingMaintenanceRecord == null) {
            return null;
        }

        existingMaintenanceRecord.setMaintenanceType(maintenanceRecord.getMaintenanceType());
        existingMaintenanceRecord.setMaintenanceDate(maintenanceRecord.getMaintenanceDate());
        existingMaintenanceRecord.setMaintenanceCost(maintenanceRecord.getMaintenanceCost());
        existingMaintenanceRecord.setMechanicNotes(maintenanceRecord.getMechanicNotes());
        existingMaintenanceRecord.setVehicle(maintenanceRecord.getVehicle());

        return maintenanceRecordRepository.save(existingMaintenanceRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenanceRecord(@PathVariable Integer id) {
        maintenanceRecordRepository.deleteById(id);
    }
}

