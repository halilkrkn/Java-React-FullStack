package com.halilkrkn.rentACar.service.dto.vehicle;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Vehicle}
 */
@Value
@Data
public class UpdateVehicleRequest implements Serializable {
    Integer vehicleId;
    String brand;
    String model;
    Integer years;
    String plateNumber;
    Double price;
    String status;
}