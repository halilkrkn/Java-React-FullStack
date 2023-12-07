package com.halilkrkn.rentACar.repository;

import com.halilkrkn.rentACar.model.Reservation;
import com.halilkrkn.rentACar.service.dto.reservation.response.GetListReservationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    // Devired Query ile Reservation tablosundan reservationDate alanına göre sorgu yapılıyor.
    List<Reservation> findByReservationDate(Timestamp reservationDate);

    // JPQL ile reservationDate alanına göre sorgu yapılıyor.
    @Query("SELECT new com.halilkrkn.rentACar.service.dto.reservation.response.GetListReservationResponse(r.reservationId, r.totalPrice) FROM Reservation r WHERE r.totalPrice = :reservationTotalPrice")
    List<GetListReservationResponse> findByReservationTotalPrice(Double reservationTotalPrice);

    boolean existsByReservationId(Integer reservationId);

    boolean existsByTotalPrice(Double totalPrice);

}

