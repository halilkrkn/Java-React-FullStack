package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.MaintenanceRecord;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.request.AddMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.request.UpdateMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.response.GetListMaintenanceRecordResponse;

import java.util.List;

public interface MaintenanceRecordService {
    void add(AddMaintenanceRecordRequest addMaintenanceRecordRequest);
    void update(Integer id, UpdateMaintenanceRecordRequest updateMaintenanceRecordRequest);
    void delete(Integer id);

    List<MaintenanceRecord> findByMaintenanceType(String maintenanceType);

    List<GetListMaintenanceRecordResponse> findByMaintenanceRecordMaintenanceCost(Double maintenanceCost);

    MaintenanceRecord findById(Integer id);

}
