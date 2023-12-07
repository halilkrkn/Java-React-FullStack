package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.service.abstracts.ReservationService;
import com.halilkrkn.rentACar.service.dto.reservation.request.AddReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.request.UpdateReservationRequest;
import com.halilkrkn.rentACar.service.dto.reservation.response.GetListReservationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddReservationRequest reservation) {
        reservationService.add(reservation);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody @Valid UpdateReservationRequest reservation) {
        reservationService.update(id, reservation);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        reservationService.delete(id);
    }

    @GetMapping("/reservationDate")
    public List<Reservation> findByReservationDate(@RequestParam Timestamp reservationDate) {
      return reservationService.findByReservationDate(reservationDate);
    }

    @GetMapping("/reservationTotalPrice")
    public List<GetListReservationResponse> findByReservationTotalPrice(@RequestParam Double reservationTotalPrice) {
      return reservationService.findByReservationTotalPrice(reservationTotalPrice);
    }


}

