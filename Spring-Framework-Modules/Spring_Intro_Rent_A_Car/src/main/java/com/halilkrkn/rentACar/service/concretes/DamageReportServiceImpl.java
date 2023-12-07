package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.DamageReport;
import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.DamageReportRepository;
import com.halilkrkn.rentACar.service.abstracts.DamageReportService;
import com.halilkrkn.rentACar.service.abstracts.RentalService;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.damageReport.request.AddDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.request.UpdateDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.response.GetListDamageReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DamageReportServiceImpl implements DamageReportService {


    private final DamageReportRepository damageReportRepository;
    private final RentalService rentalService;
    private final VehicleService vehicleService;


    @Override
    public void add(AddDamageReportRequest addDamageReportRequest) {
        if (damageReportRepository.existsByDamageDescription(addDamageReportRequest.getDamageDescription())) {
            throw new RuntimeException("Damage description already exists");
        }
        DamageReport damageReport = new DamageReport();
        damageReport.setDamageDescription(addDamageReportRequest.getDamageDescription());
        damageReport.setEstimatedRepairCost(addDamageReportRequest.getEstimatedRepairCost());
        damageReport.setReportDate(addDamageReportRequest.getReportDate());
        damageReport.setEstimatedRepairCost(addDamageReportRequest.getEstimatedRepairCost());

        Rental rentalId = rentalService.findById(addDamageReportRequest.getRentalId());
        damageReport.setRental(rentalId);

        Vehicle vehicleId = vehicleService.findById(addDamageReportRequest.getVehicleId());
        damageReport.setVehicle(vehicleId);
        damageReportRepository.save(damageReport);

    }

    @Override
    public void update(Integer id, UpdateDamageReportRequest updateDamageReportRequest) {
        if (!damageReportRepository.existsByReportId(id)) {
            throw new RuntimeException("Damage report not found");
        }

        DamageReport damageReport = damageReportRepository.findById(id).orElseThrow();
        damageReport.setDamageDescription(updateDamageReportRequest.getDamageDescription());
        damageReport.setEstimatedRepairCost(updateDamageReportRequest.getEstimatedRepairCost());
        damageReport.setReportDate(updateDamageReportRequest.getReportDate());
        damageReport.setEstimatedRepairCost(updateDamageReportRequest.getEstimatedRepairCost());

        Rental rentalId = rentalService.findById(updateDamageReportRequest.getRentalId());
        damageReport.setRental(rentalId);

        Vehicle vehicleId = vehicleService.findById(updateDamageReportRequest.getVehicleId());
        damageReport.setVehicle(vehicleId);
        damageReportRepository.save(damageReport);
        damageReportRepository.save(damageReport);

    }

    @Override
    public void delete(Integer id) {
        damageReportRepository.deleteById(id);
    }

    @Override
    public List<GetListDamageReportResponse> findByDamageReportEstimatedRepairCost(Double estimatedRepairCost) {
        return damageReportRepository.findByEstimatedRepairCost(estimatedRepairCost)
                .stream()
                .map((damageReport) -> new GetListDamageReportResponse(damageReport.getReportId(), damageReport.getEstimatedRepairCost()))
                .toList();
    }

    @Override
    public List<DamageReport> findByDamageDescription(String damageDescription) {
        return damageReportRepository.findByDamageDescription(damageDescription);
    }

    @Override
    public DamageReport findById(Integer id) {
        return damageReportRepository.findById(id).orElseThrow();
    }
}
