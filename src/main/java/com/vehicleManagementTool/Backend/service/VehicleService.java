package com.vehicleManagementTool.Backend.service;

import com.vehicleManagementTool.Backend.DTO.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getAllVehicles();
    VehicleDTO createVehicle(VehicleDTO vehicle);

    VehicleDTO getVehicleById(long vehicleId);

    VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicleDTO);

    void deleteVehicle(Long vehicleId);
}
