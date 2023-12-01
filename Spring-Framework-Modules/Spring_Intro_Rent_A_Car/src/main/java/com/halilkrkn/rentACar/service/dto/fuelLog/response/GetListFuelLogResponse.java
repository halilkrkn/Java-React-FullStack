package com.halilkrkn.rentACar.service.dto.fuelLog.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListFuelLogResponse {

    private Integer logId;
    private Double fuelQuantity;
}
