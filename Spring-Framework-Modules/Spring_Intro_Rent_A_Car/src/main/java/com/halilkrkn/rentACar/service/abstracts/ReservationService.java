package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.service.dto.reservation.AddReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.UpdateReservationRequest;

public interface ReservationService {
    void add(AddReservationRequest addReservationRequest);
    void update(Integer id, UpdateReservationRequest updateReservationRequest);
    void delete(Integer id);
}
