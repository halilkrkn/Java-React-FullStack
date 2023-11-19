package com.halilkrkn.rentACar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "Rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "reservation_date")
    private Timestamp reservationDate;

    @Column(name = "rental_date")
    private Timestamp rentalDate;

    @Column(name = "return_date")
    private Timestamp returnDate;

    @Column(name = "rental_price")
    private Double rentalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}