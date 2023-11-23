package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.maintanenceRecord.AddMaintenanceRecordRequest;
import com.halilkrkn.rentACar.service.dto.maintanenceRecord.UpdateMaintenanceRecordRequest;

public interface MaintenanceRecordService {
    void add(AddMaintenanceRecordRequest addMaintenanceRecordRequest);
    void update(Integer id, UpdateMaintenanceRecordRequest updateMaintenanceRecordRequest);
    void delete(Integer id);
}
