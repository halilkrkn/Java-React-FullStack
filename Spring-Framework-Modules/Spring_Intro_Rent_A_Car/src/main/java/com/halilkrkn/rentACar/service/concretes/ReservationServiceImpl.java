package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.repository.ReservationRepository;
import com.halilkrkn.rentACar.service.abstracts.ReservationService;
import com.halilkrkn.rentACar.service.dto.reservation.request.AddReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.request.UpdateReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.response.GetListReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


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

    @Override
    public List<GetListReservationResponse> findByReservationTotalPrice(Double reservationTotalPrice) {
        return reservationRepository.findByReservationTotalPrice(reservationTotalPrice);
    }

    @Override
    public List<Reservation> findByReservationDate(Timestamp reservationDate) {
        return reservationRepository.findByReservationDate(reservationDate);
    }
}
