package com.halilkrkn.rentACar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "rental")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FuelLog> fuelLog;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DamageReport> damageReport;

}