package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.DamageReport;
import com.halilkrkn.rentACar.service.dto.damageReport.request.AddDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.request.UpdateDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.response.GetListDamageReportResponse;

import java.util.List;

public interface DamageReportService {
    void add(AddDamageReportRequest addDamageReportRequest);
    void update(Integer id, UpdateDamageReportRequest updateDamageReportRequest);
    void delete(Integer id);

    List<GetListDamageReportResponse> findByDamageReportEstimatedRepairCost(Double estimatedRepairCost);

    List<DamageReport> findByDamageDescription(String damageDescription);

}
