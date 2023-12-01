package com.halilkrkn.rentACar.service.dto.damageReport.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListDamageReportResponse {
    private Integer reportId;
    private Double estimatedRepairCost;
}
