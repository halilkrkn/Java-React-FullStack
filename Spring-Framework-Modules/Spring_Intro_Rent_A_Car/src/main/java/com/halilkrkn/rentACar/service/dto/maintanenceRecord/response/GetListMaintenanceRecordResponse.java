package com.halilkrkn.rentACar.service.dto.maintanenceRecord.response;

import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GetListMaintenanceRecordResponse {

    private Integer recordId;
    private Double maintenanceCost;
//    private GetListVehicleResponse vehicle;
}
