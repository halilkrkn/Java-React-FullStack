package com.halilkrkn.rentACar.service.dto.damageReport.request;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.model.Vehicle;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.DamageReport}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDamageReportRequest implements Serializable {
    @Positive
    Integer reportId;
    @Length(min = 10, max = 100, message = "Damage description must be between 10 and 100 characters")
    private String damageDescription;
    @Positive(message = "Estimated repair cost must be positive")
    private Double estimatedRepairCost;
    @Positive(message = "Report date must be positive")
    private Timestamp reportDate;
    @Positive(message = "Vehicle id must be positive")
    private Integer vehicleId;
    @Positive(message = "Rental id must be positive")
    private Integer rentalId;
}