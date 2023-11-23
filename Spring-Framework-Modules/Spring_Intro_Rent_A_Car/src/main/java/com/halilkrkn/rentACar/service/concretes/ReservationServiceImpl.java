package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.repository.ReservationRepository;
import com.halilkrkn.rentACar.service.abstracts.ReservationService;
import com.halilkrkn.rentACar.service.dto.reservation.AddReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.UpdateReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public void add(AddReservationRequest addReservationRequest) {

        Reservation reservation = new Reservation();
        reservation.setReservationDate(addReservationRequest.getReservationDate());
        reservation.setStartDate(addReservationRequest.getStartDate());
        reservation.setEndDate(addReservationRequest.getEndDate());
        reservation.setTotalPrice(addReservationRequest.getTotalPrice());
        reservation.setCustomer(addReservationRequest.getCustomer());
        reservation.setVehicle(addReservationRequest.getVehicle());

        reservationRepository.save(reservation);


    }

    @Override
    public void update(Integer id, UpdateReservationRequest updateReservationRequest) {

            Reservation reservation = reservationRepository.findById(id).orElseThrow();
            reservation.setReservationDate(updateReservationRequest.getReservationDate());
            reservation.setStartDate(updateReservationRequest.getStartDate());
            reservation.setEndDate(updateReservationRequest.getEndDate());
            reservation.setTotalPrice(updateReservationRequest.getTotalPrice());
            reservation.setCustomer(updateReservationRequest.getCustomer());
            reservation.setVehicle(updateReservationRequest.getVehicle());

            reservationRepository.save(reservation);

    }

    @Override
    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }
}
