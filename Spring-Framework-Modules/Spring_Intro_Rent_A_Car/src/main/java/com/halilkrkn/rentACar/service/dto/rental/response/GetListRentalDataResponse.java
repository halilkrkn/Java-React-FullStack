package com.halilkrkn.rentACar.service.dto.rental.response;

import com.halilkrkn.rentACar.service.dto.customer.response.GetListCustomerResponse;
import com.halilkrkn.rentACar.service.dto.vehicle.response.GetListVehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
public class GetListRentalDataResponse {
    private Integer transactionId;
    private Timestamp rentalDate;
//    private GetListVehicleResponse vehicle;
//    private GetListCustomerResponse customer;
}
