package com.vehicleManagementTool.Backend.mapper;

import com.vehicleManagementTool.Backend.DTO.VehicleDTO;
import com.vehicleManagementTool.Backend.model.Vehicle;

public class VehicleMapper {

    public static VehicleDTO mapToVehicleDTO(Vehicle vehicle){
        VehicleDTO vehicleDTO = new VehicleDTO(
                vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                vehicle.getConditionVehicle(), vehicle.getMileage(),
                vehicle.getConstructionOfYear(), vehicle.getFuelKind()
        );
        return vehicleDTO;
    }

    public static Vehicle mapToVehicle(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle(
                vehicleDTO.getId(), vehicleDTO.getBrand(), vehicleDTO.getModel(),
                vehicleDTO.getConditionVehicle(), vehicleDTO.getMileage(),
                vehicleDTO.getConstructionOfYear(), vehicleDTO.getFuelKind()
        );
        return vehicle;
    }
}
