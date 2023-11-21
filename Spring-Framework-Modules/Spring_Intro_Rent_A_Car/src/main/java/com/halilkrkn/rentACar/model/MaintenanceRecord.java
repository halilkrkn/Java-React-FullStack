package com.halilkrkn.rentACar.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "maintenancerecords")
public class MaintenanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "maintenance_type")
    private String maintenanceType;

    @Column(name = "maintenance_date")
    private Timestamp maintenanceDate;

    @Column(name = "maintenance_cost")
    private Double maintenanceCost;

    @Column(name = "mechanic_notes")
    private String mechanicNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}

