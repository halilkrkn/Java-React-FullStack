package com.halilkrkn.rentACar.controller;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentalRepository rentalRepository;

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Integer id) {
        return rentalRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalRepository.save(rental);
    }

    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Integer id, @RequestBody Rental rental) {
        Rental existingRental = rentalRepository.findById(id).orElse(null);
        if (existingRental == null) {
            return null;
        }

        existingRental.setReservationDate(rental.getReservationDate());
        existingRental.setRentalDate(rental.getRentalDate());
        existingRental.setReturnDate(rental.getReturnDate());
        existingRental.setRentalPrice(rental.getRentalPrice());
        existingRental.setCustomer(rental.getCustomer());
        existingRental.setVehicle(rental.getVehicle());
        existingRental.setFuelLog(rental.getFuelLog());
        existingRental.setDamageReport(rental.getDamageReport());

        return rentalRepository.save(existingRental);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Integer id) {
        rentalRepository.deleteById(id);
    }
}
