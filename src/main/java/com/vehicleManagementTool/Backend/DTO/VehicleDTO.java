package com.vehicleManagementTool.Backend.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private long id;
    private String brand;

    private String model;

    private String conditionVehicle;

    private int mileage;

    private int constructionOfYear;

    private String fuelKind;

}
