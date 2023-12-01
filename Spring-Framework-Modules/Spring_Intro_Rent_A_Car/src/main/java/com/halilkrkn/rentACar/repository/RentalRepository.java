package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.Rental;
import com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    // Devired ile RentalPrice'a göre filtreleme
    List<Rental> getAllByRentalPrice(Double rentalPrice);

    // JPQL ile RentalDate'a göre filtreleme
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.rental.response.GetListRentalDataResponse(r.transactionId, r.rentalDate) FROM Rental r WHERE r.rentalDate = :rentalDate")
    List<GetListRentalDataResponse> getAllByByRentalDate(Timestamp rentalDate);

}

