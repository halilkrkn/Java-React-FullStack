package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.customer.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.AddDamageReportRequest;
import com.halilkrkn.rentACar.service.dto.damageReport.UpdateDamageReportRequest;

public interface DamageReportService {
    void add(AddDamageReportRequest addDamageReportRequest);
    void update(Integer id, UpdateDamageReportRequest updateDamageReportRequest);
    void delete(Integer id);
}
