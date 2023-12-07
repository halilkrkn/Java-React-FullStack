package com.halilkrkn.rentACar.service.dto.fuelLog.request;

import com.halilkrkn.rentACar.model.Rental;
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
 * DTO for {@link com.halilkrkn.rentACar.model.FuelLog}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFuelLogRequest implements Serializable {
    @NotBlank(message = "Fuel type is mandatory")
    private  String fuelType;
    @NotBlank(message = "Fuel quantity is mandatory")
    private  Double fuelQuantity;
    @Positive(message = "Estimated repair cost must be positive")
    private  Double fuelCost;
    @NotBlank(message = "Report date is mandatory")
    private  Timestamp dateRecorded;
    @Positive(message = "Vehicle id must be positive")
    private  int vehicleId;
    @Positive(message = "Rental id must be positive")
    private  int rentalId;
}