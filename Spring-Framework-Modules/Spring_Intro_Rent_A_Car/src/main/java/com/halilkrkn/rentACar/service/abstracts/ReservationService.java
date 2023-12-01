package com.halilkrkn.rentACar.service.abstracts;

import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.service.dto.reservation.request.AddReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.request.UpdateReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.response.GetListReservationResponse;

import java.sql.Timestamp;
import java.util.List;

public interface ReservationService {
    void add(AddReservationRequest addReservationRequest);
    void update(Integer id, UpdateReservationRequest updateReservationRequest);
    void delete(Integer id);

    List<GetListReservationResponse> findByReservationTotalPrice(Double reservationTotalPrice);

    List<Reservation> findByReservationDate(Timestamp reservationDate);

}
