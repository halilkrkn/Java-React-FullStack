package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.service.abstracts.RentalService;
import com.halilkrkn.rentACar.service.dto.rental.request.AddRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.request.UpdateRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public void add(@RequestBody @Valid AddRentalRequest rental) {
        rentalService.add(rental);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody @Valid UpdateRentalRequest rental) {
        rentalService.update(id, rental);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        rentalService.delete(id);
    }

    @GetMapping("/rental-price")
    public List<Rental> findByRentalPrice(@RequestParam Double rentalPrice) {
        return rentalService.findByRentalPrice(rentalPrice);
    }

    @GetMapping("/rental-date")
    public List<GetListRentalDataResponse> findByRentalDate(@RequestParam Timestamp rentalDate) {
        return rentalService.findByRentalDate(rentalDate);
    }

}
