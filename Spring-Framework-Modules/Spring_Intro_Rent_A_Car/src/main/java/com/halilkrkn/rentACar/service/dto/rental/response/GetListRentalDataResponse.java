package com.halilkrkn.rentACar.service.dto.rental.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalDataResponse {
    private Integer transactionId;
    private Timestamp rentalDate;
}
