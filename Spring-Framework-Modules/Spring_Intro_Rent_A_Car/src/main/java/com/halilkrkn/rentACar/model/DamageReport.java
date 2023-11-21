package com.halilkrkn.rentACar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Entity
@Data
@Table(name = "damagereports")
public class DamageReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "damage_description")
    private String damageDescription;

    @Column(name = "estimated_repair_cost")
    private Double estimatedRepairCost;

    @Column(name = "report_date")
    private Timestamp reportDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental rental;
}
