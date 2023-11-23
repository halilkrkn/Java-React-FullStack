package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.CustomerService;
import com.halilkrkn.rentACar.service.dto.customer.AddCustomerRequest;
import com.halilkrkn.rentACar.service.dto.customer.UpdateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public void add(@RequestBody AddCustomerRequest customer) {
        customerService.add(customer);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateCustomerRequest customer) {
        customerService.update(id, customer);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }

}
