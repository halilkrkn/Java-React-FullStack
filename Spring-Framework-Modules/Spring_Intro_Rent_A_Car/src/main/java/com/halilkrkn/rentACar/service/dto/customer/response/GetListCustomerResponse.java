package com.halilkrkn.rentACar.service.dto.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCustomerResponse {
    private Integer customerId;
    private String firstName;
    private String email;
}
