package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.ReservationRepository;
import com.halilkrkn.rentACar.service.abstracts.CustomerService;
import com.halilkrkn.rentACar.service.abstracts.ReservationService;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
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
    private final CustomerService customerService;
    private final VehicleService vehicleService;

    @Override
    public void add(AddReservationRequest addReservationRequest) {
       if (reservationRepository.existsByTotalPrice(addReservationRequest.getTotalPrice())) {
            throw new RuntimeException("Reservation already exists");
        }

        Reservation reservation = new Reservation();
        reservation.setReservationDate(addReservationRequest.getReservationDate());
        reservation.setStartDate(addReservationRequest.getStartDate());
        reservation.setEndDate(addReservationRequest.getEndDate());
        reservation.setTotalPrice(addReservationRequest.getTotalPrice());
        Customer customerId = customerService.findById(addReservationRequest.getCustomerId());
        reservation.setCustomer(customerId);
        Vehicle vehicleId = vehicleService.findById(addReservationRequest.getVehicleId());
        reservation.setVehicle(vehicleId);

        reservationRepository.save(reservation);


    }

    @Override
    public void update(Integer id, UpdateReservationRequest updateReservationRequest) {

        if (!reservationRepository.existsByReservationId(id)) {
            throw new RuntimeException("Reservation not found");
        }
        Reservation reservation = reservationRepository.findById(id).orElseThrow();
        reservation.setReservationDate(updateReservationRequest.getReservationDate());
        reservation.setStartDate(updateReservationRequest.getStartDate());
        reservation.setEndDate(updateReservationRequest.getEndDate());
        reservation.setTotalPrice(updateReservationRequest.getTotalPrice());
        Customer customerId = customerService.findById(updateReservationRequest.getCustomerId());
        reservation.setCustomer(customerId);
        Vehicle vehicleId = vehicleService.findById(updateReservationRequest.getVehicleId());
        reservation.setVehicle(vehicleId);

        reservationRepository.save(reservation);

    }

    @Override
    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<GetListReservationResponse> findByReservationTotalPrice(Double reservationTotalPrice) {
        return reservationRepository.findByReservationTotalPrice(reservationTotalPrice)
                .stream()
                .map((reservation) -> new GetListReservationResponse(reservation.getReservationId(), reservation.getReservationTotalPrice()))
                .toList();
    }

    @Override
    public List<Reservation> findByReservationDate(Timestamp reservationDate) {
        return reservationRepository.findByReservationDate(reservationDate);
    }

    @Override
    public Reservation findById(Integer id) {
        return reservationRepository.findById(id).orElseThrow();
    }
}
