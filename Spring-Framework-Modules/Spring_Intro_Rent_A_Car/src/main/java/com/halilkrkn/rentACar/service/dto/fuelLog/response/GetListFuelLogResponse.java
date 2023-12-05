package com.halilkrkn.rentACar.service.dto.fuelLog.response;

import com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListFuelLogResponse {
    private Integer logId;
    private Double fuelQuantity;
//    private GetListVehicleResponse vehicle;
//    private GetListRentalDataResponse rental;
}
