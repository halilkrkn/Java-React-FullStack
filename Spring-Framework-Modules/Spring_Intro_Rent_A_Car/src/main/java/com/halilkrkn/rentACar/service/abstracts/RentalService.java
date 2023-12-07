package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.service.dto.rental.request.AddRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.request.UpdateRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse;

import java.sql.Timestamp;
import java.util.List;

public interface RentalService {
    void add(AddRentalRequest addRentalRequest);
    void update(Integer id, UpdateRentalRequest updateRentalRequest);
    void delete(Integer id);
    List<Rental> findByRentalPrice(Double rentalPrice);
    List<GetListRentalDataResponse> findByRentalDate(Timestamp rentalDate);

    Rental findById(Integer id);

}
