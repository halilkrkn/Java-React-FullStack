package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.DamageReport;
import com.halilkrkn.rentACar.service.abstracts.DamageReportService;
import com.halilkrkn.rentACar.service.dto.damageReport.request.AddDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.request.UpdateDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.response.GetListDamageReportResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/damagereports")
@RequiredArgsConstructor
public class DamageReportController {

    private final DamageReportService damageReportService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddDamageReportRequest damageReport) {
        damageReportService.add(damageReport);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody @Valid UpdateDamageReportRequest damageReport) {
        damageReportService.update(id, damageReport);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        damageReportService.delete(id);
    }

    @GetMapping("/estimated-repair-cost")
    public List<GetListDamageReportResponse> findByDamageReportEstimatedRepairCost(@RequestParam Double estimatedRepairCost) {
        return damageReportService.findByDamageReportEstimatedRepairCost(estimatedRepairCost);
    }

    @GetMapping("/damage-description")
    public List<DamageReport> findByDamageDescription(@RequestParam String damageDescription) {
        return damageReportService.findByDamageDescription(damageDescription);
    }
}

