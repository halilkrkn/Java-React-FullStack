package com.halilkrkn.rentACar.service.dto.damageReport;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.model.Vehicle;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.DamageReport}
 */
@Value
@Data
public class UpdateDamageReportRequest implements Serializable {
    Integer reportId;
    String damageDescription;
    Double estimatedRepairCost;
    Timestamp reportDate;
    Vehicle vehicle;
    Rental rental;
}