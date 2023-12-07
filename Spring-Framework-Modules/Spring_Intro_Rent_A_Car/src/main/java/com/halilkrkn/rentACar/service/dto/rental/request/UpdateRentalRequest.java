package com.halilkrkn.rentACar.service.dto.rental.request;

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
 * DTO for {@link com.halilkrkn.rentACar.model.Rental}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest implements Serializable {
    @Positive
    private Integer transactionId;
    @NotBlank(message = "Reservation date is mandatory")
    private Timestamp reservationDate;
    @NotBlank(message = "Rental date is mandatory")
    private Timestamp rentalDate;
    @NotBlank(message = "Return date is mandatory")
    private Timestamp returnDate;
    @Positive(message = "Rental price must be positive")
    private Double rentalPrice;
    @Positive(message = "Estimated repair cost must be positive")
    private Integer customerId;
    @Positive(message = "Vehicle id must be positive")
    private Integer vehicleId;

}