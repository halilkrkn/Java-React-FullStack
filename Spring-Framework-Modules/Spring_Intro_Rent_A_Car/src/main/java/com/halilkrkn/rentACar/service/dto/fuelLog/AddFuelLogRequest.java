package com.halilkrkn.rentACar.service.dto.fuelLog;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.model.Vehicle;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.FuelLog}
 */
@Value
@Data
public class AddFuelLogRequest implements Serializable {
    String fuelType;
    Double fuelQuantity;
    Double fuelCost;
    Timestamp dateRecorded;
    Vehicle vehicle;
    Rental rental;
}