package com.halilkrkn.rentACar.service.dto.vehicle.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListVehicleResponse {
    private Integer vehicleId;
    private String brand;
    private String model;
    private Integer years;
    private String plateNumber;
    private Double price;
    private String status;
}
