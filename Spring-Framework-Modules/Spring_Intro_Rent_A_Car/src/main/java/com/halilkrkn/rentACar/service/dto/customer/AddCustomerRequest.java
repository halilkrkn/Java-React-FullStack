package com.halilkrkn.rentACar.service.dto.customer;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Customer}
 */
@Value
@Data
public class AddCustomerRequest implements Serializable {
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String address;
}