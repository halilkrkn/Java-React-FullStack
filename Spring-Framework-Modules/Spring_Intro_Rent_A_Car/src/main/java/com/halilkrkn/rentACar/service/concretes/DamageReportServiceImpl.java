package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.DamageReport;
import com.halilkrkn.rentACar.repository.DamageReportRepository;
import com.halilkrkn.rentACar.service.abstracts.DamageReportService;
import com.halilkrkn.rentACar.service.dto.damageReport.AddDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.UpdateDamageReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DamageReportServiceImpl implements DamageReportService {


    private final DamageReportRepository damageReportRepository;


    @Override
    public void add(AddDamageReportRequest addDamageReportRequest) {

        DamageReport damageReport = new DamageReport();
        damageReport.setDamageDescription(addDamageReportRequest.getDamageDescription());
        damageReport.setEstimatedRepairCost(addDamageReportRequest.getEstimatedRepairCost());
        damageReport.setReportDate(addDamageReportRequest.getReportDate());
        damageReport.setVehicle(addDamageReportRequest.getVehicle());
        damageReport.setRental(addDamageReportRequest.getRental());
        damageReport.setEstimatedRepairCost(addDamageReportRequest.getEstimatedRepairCost());

        damageReportRepository.save(damageReport);

    }

    @Override
    public void update(Integer id, UpdateDamageReportRequest updateDamageReportRequest) {

            DamageReport damageReport = damageReportRepository.findById(id).orElseThrow();
            damageReport.setDamageDescription(updateDamageReportRequest.getDamageDescription());
            damageReport.setEstimatedRepairCost(updateDamageReportRequest.getEstimatedRepairCost());
            damageReport.setReportDate(updateDamageReportRequest.getReportDate());
            damageReport.setVehicle(updateDamageReportRequest.getVehicle());
            damageReport.setRental(updateDamageReportRequest.getRental());
            damageReport.setEstimatedRepairCost(updateDamageReportRequest.getEstimatedRepairCost());

            damageReportRepository.save(damageReport);

    }

    @Override
    public void delete(Integer id) {
        damageReportRepository.deleteById(id);
    }
}
