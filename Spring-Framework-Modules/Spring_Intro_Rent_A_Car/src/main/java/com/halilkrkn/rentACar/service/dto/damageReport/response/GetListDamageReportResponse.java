package com.halilkrkn.rentACar.service.dto.damageReport.response;


import com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GetListDamageReportResponse {
    private Integer reportId;
    private Double estimatedRepairCost;
//    private GetListVehicleResponse vehicle;
//    private GetListRentalDataResponse rental;
}
