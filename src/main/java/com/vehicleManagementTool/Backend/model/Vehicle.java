package com.vehicleManagementTool.Backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle_table")
public class Vehicle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "condition_vehicle")
    private String conditionVehicle;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "construction_of_year")
    private int constructionOfYear;

    @Column(name = "fuel_kind")
    private String fuelKind;
}
