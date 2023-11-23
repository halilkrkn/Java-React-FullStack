package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.service.abstracts.RentalService;
import com.halilkrkn.rentACar.service.dto.rental.AddRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.UpdateRentalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/add")
    public void add(@RequestBody AddRentalRequest rental) {
        rentalService.add(rental);
    }

    @PostMapping
    public void update(@PathVariable Integer id, @RequestBody UpdateRentalRequest rental) {
        rentalService.update(id, rental);
    }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        rentalService.delete(id);
    }

}
