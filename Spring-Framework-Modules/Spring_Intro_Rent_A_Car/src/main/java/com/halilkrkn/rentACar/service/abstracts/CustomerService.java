package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.service.dto.customer.request.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.request.UpdateCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest addCustomerRequest);

    void update(Integer id, UpdateCustomerRequest updateCustomerRequest);

    void delete(Integer id);

    // Pjql ile isme ve email'e göre filtreleme
    List<GetListCustomerResponse> findByCustomerFirstName(String name);
    List<GetListCustomerResponse> findByCustomerEmail(String email);

    // Derived Query ile isme göre filtreleme
    List<Customer> findCustomerDTOByFirstName(String name);
    List<Customer> findCustomerDTOByEmail(String email);

}

