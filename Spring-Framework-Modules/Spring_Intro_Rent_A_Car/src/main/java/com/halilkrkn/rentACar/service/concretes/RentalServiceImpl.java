package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.repository.RentalRepository;
import com.halilkrkn.rentACar.service.abstracts.RentalService;
import com.halilkrkn.rentACar.service.dto.rental.AddRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.UpdateRentalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    @Override
    public void add(AddRentalRequest addRentalRequest) {
        Rental rental = new Rental();
        rental.setReservationDate(addRentalRequest.getReservationDate());
        rental.setRentalDate(addRentalRequest.getRentalDate());
        rental.setReturnDate(addRentalRequest.getReturnDate());
        rental.setRentalPrice(addRentalRequest.getRentalPrice());
        rental.setVehicle(addRentalRequest.getVehicle());
        rental.setCustomer(addRentalRequest.getCustomer());

        rentalRepository.save(rental);
    }

    @Override
    public void update(Integer id, UpdateRentalRequest updateRentalRequest) {

        Rental rental = rentalRepository.findById(id).orElseThrow();
        rental.setReservationDate(updateRentalRequest.getReservationDate());
        rental.setRentalDate(updateRentalRequest.getRentalDate());
        rental.setReturnDate(updateRentalRequest.getReturnDate());
        rental.setRentalPrice(updateRentalRequest.getRentalPrice());
        rental.setVehicle(updateRentalRequest.getVehicle());
        rental.setCustomer(updateRentalRequest.getCustomer());

        rentalRepository.save(rental);
    }

    @Override
    public void delete(Integer id) {
        rentalRepository.deleteById(id);
    }
}
