package com.halilkrkn.rentACar.service.concretes;

import com.halilkrkn.rentACar.model.Customer;
import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.model.Vehicle;
import com.halilkrkn.rentACar.repository.RentalRepository;
import com.halilkrkn.rentACar.service.abstracts.CustomerService;
import com.halilkrkn.rentACar.service.abstracts.RentalService;
import com.halilkrkn.rentACar.service.abstracts.VehicleService;
import com.halilkrkn.rentACar.service.dto.rental.request.AddRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.request.UpdateRentalRequest;
import com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final VehicleService vehicleService;
    private final CustomerService customerService;

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        if(rentalRepository.existsByRentalPrice(addRentalRequest.getRentalPrice())){
            throw new RuntimeException("Rental price already exists");
        }
        Rental rental = new Rental();
        rental.setReservationDate(addRentalRequest.getReservationDate());
        rental.setRentalDate(addRentalRequest.getRentalDate());
        rental.setReturnDate(addRentalRequest.getReturnDate());
        rental.setRentalPrice(addRentalRequest.getRentalPrice());
        Vehicle vehicleId = vehicleService.findById(addRentalRequest.getVehicleId());
        rental.setVehicle(vehicleId);
        Customer customerId = customerService.findById(addRentalRequest.getCustomerId());
        rental.setCustomer(customerId);

        rentalRepository.save(rental);
    }

    @Override
    public void update(Integer id, UpdateRentalRequest updateRentalRequest) {
        if(!rentalRepository.existsByTransactionId(id)){
            throw new RuntimeException("Rental not found");
        }
        Rental rental = rentalRepository.findById(id).orElseThrow();
        rental.setReservationDate(updateRentalRequest.getReservationDate());
        rental.setRentalDate(updateRentalRequest.getRentalDate());
        rental.setReturnDate(updateRentalRequest.getReturnDate());
        rental.setRentalPrice(updateRentalRequest.getRentalPrice());
        Vehicle vehicleId = vehicleService.findById(updateRentalRequest.getVehicleId());
        rental.setVehicle(vehicleId);
        Customer customerId = customerService.findById(updateRentalRequest.getCustomerId());
        rental.setCustomer(customerId);

        rentalRepository.save(rental);
    }

    @Override
    public void delete(Integer id) {
        rentalRepository.deleteById(id);
    }

    @Override
    public List<Rental> findByRentalPrice(Double rentalPrice) {
        return rentalRepository.getAllByRentalPrice(rentalPrice);
    }

    @Override
    public List<GetListRentalDataResponse> findByRentalDate(Timestamp rentalDate) {
        return rentalRepository.getAllByByRentalDate(rentalDate)
                .stream()
                .map((rental) -> new GetListRentalDataResponse(rental.getTransactionId(), rental.getRentalDate()))
                .toList();
    }

    @Override
    public Rental findById(Integer id) {
        return rentalRepository.findById(id).orElseThrow();
    }
}
