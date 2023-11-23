package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.ReservationService;
import com.halilkrkn.rentACar.service.dto.reservation.AddReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.UpdateReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/add")
    public void add(@RequestBody AddReservationRequest reservation) {
        reservationService.add(reservation);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateReservationRequest reservation) {
        reservationService.update(id, reservation);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        reservationService.delete(id);
    }
}

