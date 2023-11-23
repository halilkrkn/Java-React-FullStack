package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.DamageReportService;
import com.halilkrkn.rentACar.service.dto.damageReport.AddDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.UpdateDamageReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/damagereports")
@RequiredArgsConstructor
public class DamageReportController {

    private final DamageReportService damageReportService;

    @PostMapping("/add")
    public void add(@RequestBody AddDamageReportRequest damageReport) {
        damageReportService.add(damageReport);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateDamageReportRequest damageReport) {
        damageReportService.update(id, damageReport);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        damageReportService.delete(id);
    }
}

