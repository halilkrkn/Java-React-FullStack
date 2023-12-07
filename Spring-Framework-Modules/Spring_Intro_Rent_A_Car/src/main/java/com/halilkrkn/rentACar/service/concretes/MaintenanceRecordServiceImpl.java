package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.MaintenanceRecord;
import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.MaintenanceRecordRepository;
import com.halilkrkn.rentACar.service.abstracts.MaintenanceRecordService;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.request.AddMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.request.UpdateMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.response.GetListMaintenanceRecordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;
    private final VehicleService vehicleService;


    @Override
    public void add(AddMaintenanceRecordRequest addMaintenanceRecordRequest) {
        if (maintenanceRecordRepository.existsByMaintenanceType(addMaintenanceRecordRequest.getMaintenanceType())) {
            throw new RuntimeException("Maintenance type already exists");
        }

        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();
        maintenanceRecord.setMaintenanceType(addMaintenanceRecordRequest.getMaintenanceType());
        maintenanceRecord.setMaintenanceDate(addMaintenanceRecordRequest.getMaintenanceDate());
        maintenanceRecord.setMaintenanceCost(addMaintenanceRecordRequest.getMaintenanceCost());
        maintenanceRecord.setMechanicNotes(addMaintenanceRecordRequest.getMechanicNotes());
        Vehicle vehicleId = vehicleService.findById(addMaintenanceRecordRequest.getVehicleId());
        maintenanceRecord.setVehicle(vehicleId);

        maintenanceRecordRepository.save(maintenanceRecord);
    }

    @Override
    public void update(Integer id, UpdateMaintenanceRecordRequest updateMaintenanceRecordRequest) {
        if (!maintenanceRecordRepository.existsByRecordId(id)) {
            throw new RuntimeException("Maintenance record not found");
        }
        MaintenanceRecord maintenanceRecord = maintenanceRecordRepository.findById(id).orElseThrow();
        maintenanceRecord.setMaintenanceType(updateMaintenanceRecordRequest.getMaintenanceType());
        maintenanceRecord.setMaintenanceDate(updateMaintenanceRecordRequest.getMaintenanceDate());
        maintenanceRecord.setMaintenanceCost(updateMaintenanceRecordRequest.getMaintenanceCost());
        maintenanceRecord.setMechanicNotes(updateMaintenanceRecordRequest.getMechanicNotes());
        Vehicle vehicleId = vehicleService.findById(updateMaintenanceRecordRequest.getVehicleId());
        maintenanceRecord.setVehicle(vehicleId);
        maintenanceRecordRepository.save(maintenanceRecord);

    }

    @Override
    public void delete(Integer id) {
        maintenanceRecordRepository.deleteById(id);
    }

    @Override
    public List<MaintenanceRecord> findByMaintenanceType(String maintenanceType) {
        return maintenanceRecordRepository.findByMaintenanceType(maintenanceType);
    }

    @Override
    public List<GetListMaintenanceRecordResponse> findByMaintenanceRecordMaintenanceCost(Double maintenanceCost) {
        return maintenanceRecordRepository.findByMaintenanceCost(maintenanceCost)
                .stream()
                .map((maintenanceRecord) -> new GetListMaintenanceRecordResponse(maintenanceRecord.getRecordId(), maintenanceRecord.getMaintenanceCost()))
                .toList();
    }

    @Override
    public MaintenanceRecord findById(Integer id) {
        return maintenanceRecordRepository.findById(id).orElseThrow();
    }
}
