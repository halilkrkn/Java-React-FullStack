package com.halilkrkn.rentACar.service.dto.vehicle.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Vehicle}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVehicleRequest implements Serializable {
    @Min(value = 1, message = "Vehicle id must be positive")
    private Integer vehicleId;
    @NotBlank(message = "Brand is mandatory")
    private String brand;
    @Min(value = 1900, message = "Year must be greater than 1900")
    private String model;
    @Min(value = 1900, message = "Year must be greater than 1900")
    private Integer years;
    @NotBlank(message = "Plate number is mandatory")
    private String plateNumber;
    @NotBlank(message = "Color is mandatory")
    private Double price;
    @NotBlank(message = "Color is mandatory")
    private String status;

}