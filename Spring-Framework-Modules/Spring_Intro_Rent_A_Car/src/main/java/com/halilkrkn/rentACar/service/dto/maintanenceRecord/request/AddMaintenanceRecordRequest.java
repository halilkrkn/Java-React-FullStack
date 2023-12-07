package com.halilkrkn.rentACar.service.dto.maintanenceRecord.request;

import com.halilkrkn.rentACar.model.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.MaintenanceRecord}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMaintenanceRecordRequest implements Serializable {
    @NotBlank(message = "Maintenance type is mandatory")
    private String maintenanceType;
    @NotBlank(message = "Maintenance date is mandatory")
    private Timestamp maintenanceDate;
    @NotBlank(message = "Maintenance cost is mandatory")
    private Double maintenanceCost;
    @NotBlank(message = "Mechanic notes is mandatory")
    private String mechanicNotes;
    @Positive
    private Integer vehicleId;
}