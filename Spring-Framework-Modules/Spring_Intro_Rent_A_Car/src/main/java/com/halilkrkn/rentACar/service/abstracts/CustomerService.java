package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.customer.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest addCustomerRequest);

    void update(Integer id, UpdateCustomerRequest updateCustomerRequest);

    void delete(Integer id);
}

