package com.halilkrkn.rentACar.service.dto.maintanenceRecord;

import com.halilkrkn.rentACar.model.Vehicle;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.MaintenanceRecord}
 */
@Value
@Data
public class AddMaintenanceRecordRequest implements Serializable {
    String maintenanceType;
    Timestamp maintenanceDate;
    Double maintenanceCost;
    String mechanicNotes;
    Vehicle vehicle;
}