package com.halilkrkn.rentACar.service.dto.reservation.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListReservationResponse {

    private Integer reservationId;
    private Double reservationTotalPrice;
}
