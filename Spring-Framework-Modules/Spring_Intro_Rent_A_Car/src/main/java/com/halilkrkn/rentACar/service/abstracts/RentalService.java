package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.rental.AddRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.UpdateRentalRequest;

public interface RentalService {
    void add(AddRentalRequest addRentalRequest);
    void update(Integer id, UpdateRentalRequest updateRentalRequest);
    void delete(Integer id);
}
