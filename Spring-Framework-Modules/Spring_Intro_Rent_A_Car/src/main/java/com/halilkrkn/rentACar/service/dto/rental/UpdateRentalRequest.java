package com.halilkrkn.rentACar.service.dto.rental;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.Vehicle;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Rental}
 */
@Value
@Data
public class UpdateRentalRequest implements Serializable {
    Integer transactionId;
    Timestamp reservationDate;
    Timestamp rentalDate;
    Timestamp returnDate;
    Double rentalPrice;
    Customer customer;
    Vehicle vehicle;
}