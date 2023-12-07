package com.halilkrkn.rentACar.service.dto.reservation.request;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.halilkrkn.rentACar.model.Reservation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddReservationRequest implements Serializable {
    @NotBlank(message = "Reservation date is mandatory")
    private Timestamp reservationDate;
    @NotBlank(message = "Start date is mandatory")
    private Timestamp startDate;
    @NotBlank(message = "End date is mandatory")
    private Timestamp endDate;
    @Positive(message = "Total price must be positive")
    private Double totalPrice;
    @Positive(message = "Customer id must be positive")
    private Integer customerId;
    @Positive(message = "Vehicle id must be positive")
    private Integer vehicleId;
}