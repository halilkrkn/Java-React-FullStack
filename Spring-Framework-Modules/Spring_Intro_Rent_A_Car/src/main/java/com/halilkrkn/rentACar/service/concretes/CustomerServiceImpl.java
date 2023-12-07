package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.repository.CustomerRepository;
import com.halilkrkn.rentACar.service.abstracts.CustomerService;
import com.halilkrkn.rentACar.service.dto.customer.request.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.request.UpdateCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    @Override
    public void add(AddCustomerRequest addCustomerRequest) {
        if (customerRepository.existsByEmail(addCustomerRequest.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (customerRepository.existsByPhoneNumber(addCustomerRequest.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists");
        }
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

        if(!customerRepository.existsByCustomerId(id)){
            throw new RuntimeException("Customer not found");
        }
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


    // Buradda Stream api kullanarak mapper işlemleri yapılıyor.
    @Override
    public List<GetListCustomerResponse> findByCustomerFirstName(String name) {
        return customerRepository.findByCustomerFirstName(name)
                .stream()
                .map((customer) -> new GetListCustomerResponse(customer.getCustomerId(), customer.getFirstName(), customer.getEmail()))
                .toList();
    }

    @Override
    public List<GetListCustomerResponse> findByCustomerEmail(String email) {
        return customerRepository.findByCustomerEmail(email)
                .stream()
                .map((customer) -> new GetListCustomerResponse(customer.getCustomerId(), customer.getFirstName(), customer.getEmail()))
                .toList();
    }

    @Override
    public List<Customer> findCustomerDTOByFirstName(String name) {
        return customerRepository.findCustomerDTOByFirstName(name);
    }

    @Override
    public List<Customer> findCustomerDTOByEmail(String email) {
        return customerRepository.findCustomerDTOByEmail(email);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }

}
