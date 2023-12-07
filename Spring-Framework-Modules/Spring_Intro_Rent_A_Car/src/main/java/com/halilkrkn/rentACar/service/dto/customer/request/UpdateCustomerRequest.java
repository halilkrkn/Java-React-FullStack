package com.halilkrkn.rentACar.service.dto.customer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Customer}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest implements Serializable {
    @Positive
    Integer customerId;
    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;
    @Email
    private String email;
    @NotBlank(message = "Address is mandatory")
    private String address;
}