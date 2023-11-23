package com.halilkrkn.rentACar.service.dto.reservation;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.Vehicle;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Reservation}
 */
@Value
@Data
public class UpdateReservationRequest implements Serializable {
    Integer reservationId;
    Timestamp reservationDate;
    Timestamp startDate;
    Timestamp endDate;
    Double totalPrice;
    Customer customer;
    Vehicle vehicle;
}