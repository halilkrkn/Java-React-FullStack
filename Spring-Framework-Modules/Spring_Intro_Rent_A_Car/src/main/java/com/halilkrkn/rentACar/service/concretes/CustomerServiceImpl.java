package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.repository.CustomerRepository;
import com.halilkrkn.rentACar.service.abstracts.CustomerService;
import com.halilkrkn.rentACar.service.dto.customer.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.UpdateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(addCustomerRequest.getFirstName());
        customer.setLastName(addCustomerRequest.getLastName());
        customer.setAddress(addCustomerRequest.getAddress());
        customer.setPhoneNumber(addCustomerRequest.getPhoneNumber());
        customer.setEmail(addCustomerRequest.getEmail());

        customerRepository.save(customer);
    }

    @Override
    public void update(Integer id, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstName(updateCustomerRequest.getFirstName());
        customer.setLastName(updateCustomerRequest.getLastName());
        customer.setAddress(updateCustomerRequest.getAddress());
        customer.setPhoneNumber(updateCustomerRequest.getPhoneNumber());
        customer.setEmail(updateCustomerRequest.getEmail());

        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
