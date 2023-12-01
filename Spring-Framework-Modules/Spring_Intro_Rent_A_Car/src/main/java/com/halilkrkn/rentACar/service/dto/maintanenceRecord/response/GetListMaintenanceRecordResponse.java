package com.halilkrkn.rentACar.service.dto.maintanenceRecord.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListMaintenanceRecordResponse {

    private Integer recordId;

    private Double maintenanceCost;
}
