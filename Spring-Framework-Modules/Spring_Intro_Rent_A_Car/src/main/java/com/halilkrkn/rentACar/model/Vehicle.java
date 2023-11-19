package com.halilkrkn.rentACar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer vehicleId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "years")
    private Integer years;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String status;


}
