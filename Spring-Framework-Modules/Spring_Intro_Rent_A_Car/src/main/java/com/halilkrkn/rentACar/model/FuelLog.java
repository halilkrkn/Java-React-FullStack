package com.halilkrkn.rentACar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "fuellogs")
public class FuelLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Integer logId;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "fuel_quantity")
    private Double fuelQuantity;

    @Column(name = "fuel_cost")
    private Double fuelCost;

    @Column(name = "date_recorded")
    private Timestamp dateRecorded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Rental rental;
}

