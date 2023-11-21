package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.DamageReport;
import com.halilkrkn.rentACar.repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/damagereports")
public class DamageReportController {

    @Autowired
    private DamageReportRepository damageReportRepository;

    @GetMapping
    public List<DamageReport> getAllDamageReports() {
        return damageReportRepository.findAll();
    }

    @GetMapping("/{id}")
    public DamageReport getDamageReportById(@PathVariable Integer id) {
        return damageReportRepository.findById(id).orElse(null);
    }

    @PostMapping
    public DamageReport createDamageReport(@RequestBody DamageReport damageReport) {
        return damageReportRepository.save(damageReport);
    }

    @PutMapping("/{id}")
    public DamageReport updateDamageReport(@PathVariable Integer id, @RequestBody DamageReport damageReport) {
        DamageReport existingDamageReport = damageReportRepository.findById(id).orElse(null);
        if (existingDamageReport == null) {
            return null;
        }

        existingDamageReport.setDamageDescription(damageReport.getDamageDescription());
        existingDamageReport.setEstimatedRepairCost(damageReport.getEstimatedRepairCost());
        existingDamageReport.setReportDate(damageReport.getReportDate());
        existingDamageReport.setVehicle(damageReport.getVehicle());
        existingDamageReport.setRental(damageReport.getRental());

        return damageReportRepository.save(existingDamageReport);
    }

    @DeleteMapping("/{id}")
    public void deleteDamageReport(@PathVariable Integer id) {
        damageReportRepository.deleteById(id);
    }
}

