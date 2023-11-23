package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.MaintenanceRecord;
import com.halilkrkn.rentACar.repository.MaintenanceRecordRepository;
import com.halilkrkn.rentACar.service.abstracts.MaintenanceRecordService;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.AddMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.UpdateMaintenanceRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;

    @Override
    public void add(AddMaintenanceRecordRequest addMaintenanceRecordRequest) {

        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();
        maintenanceRecord.setMaintenanceType(addMaintenanceRecordRequest.getMaintenanceType());
        maintenanceRecord.setMaintenanceDate(addMaintenanceRecordRequest.getMaintenanceDate());
        maintenanceRecord.setMaintenanceCost(addMaintenanceRecordRequest.getMaintenanceCost());
        maintenanceRecord.setMechanicNotes(addMaintenanceRecordRequest.getMechanicNotes());
        maintenanceRecord.setVehicle(addMaintenanceRecordRequest.getVehicle());

    }

    @Override
    public void update(Integer id, UpdateMaintenanceRecordRequest updateMaintenanceRecordRequest) {

        MaintenanceRecord maintenanceRecord = maintenanceRecordRepository.findById(id).orElseThrow();
        maintenanceRecord.setMaintenanceType(updateMaintenanceRecordRequest.getMaintenanceType());
        maintenanceRecord.setMaintenanceDate(updateMaintenanceRecordRequest.getMaintenanceDate());
        maintenanceRecord.setMaintenanceCost(updateMaintenanceRecordRequest.getMaintenanceCost());
        maintenanceRecord.setMechanicNotes(updateMaintenanceRecordRequest.getMechanicNotes());
        maintenanceRecord.setVehicle(updateMaintenanceRecordRequest.getVehicle());

        maintenanceRecordRepository.save(maintenanceRecord);

    }

    @Override
    public void delete(Integer id) {
        maintenanceRecordRepository.deleteById(id);
    }
}
