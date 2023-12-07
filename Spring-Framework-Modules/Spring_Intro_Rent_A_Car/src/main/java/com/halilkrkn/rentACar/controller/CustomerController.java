package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.service.abstracts.CustomerService;
import com.halilkrkn.rentACar.service.dto.customer.request.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.request.UpdateCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddCustomerRequest customer) {
        customerService.add(customer);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody @Valid UpdateCustomerRequest customer) {
        customerService.update(id, customer);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }

    @GetMapping("/dto-name")
    public List<GetListCustomerResponse> findByCustomerFirstName(@RequestParam String name) {
        return customerService.findByCustomerFirstName(name);
    }

    @GetMapping("/dto-email")
    public List<GetListCustomerResponse> findByCustomerEmail(@RequestParam String email) {
        return customerService.findByCustomerEmail(email);
    }

    @GetMapping("/name")
    public List<Customer> findCustomerDTOByFirstName(@RequestParam String name) {
        return customerService.findCustomerDTOByFirstName(name);
    }

    @GetMapping("/email")
    public List<Customer> findCustomerDTOByEmail(@RequestParam String email) {
        return customerService.findCustomerDTOByEmail(email);
    }

}
