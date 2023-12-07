package com.halilkrkn.rentACar.service.dto.reservation.response;

import com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GetListReservationResponse {
    private Integer reservationId;
    private Double reservationTotalPrice;
//    private GetListCustomerResponse customer;
//    private GetListVehicleResponse vehicle;
}
