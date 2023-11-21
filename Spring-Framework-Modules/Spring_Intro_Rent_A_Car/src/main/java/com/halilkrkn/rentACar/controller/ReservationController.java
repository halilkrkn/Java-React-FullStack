package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Integer id, @RequestBody Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation == null) {
            return null;
        }

        existingReservation.setReservationDate(reservation.getReservationDate());
        existingReservation.setStartDate(reservation.getStartDate());
        existingReservation.setEndDate(reservation.getEndDate());
        existingReservation.setTotalPrice(reservation.getTotalPrice());
        existingReservation.setCustomer(reservation.getCustomer());
        existingReservation.setVehicle(reservation.getVehicle());

        return reservationRepository.save(existingReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationRepository.deleteById(id);
    }
}

