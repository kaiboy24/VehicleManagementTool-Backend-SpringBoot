package com.vehicleManagementTool.Backend.service;

import com.vehicleManagementTool.Backend.DTO.VehicleDTO;
import com.vehicleManagementTool.Backend.mapper.VehicleMapper;
import com.vehicleManagementTool.Backend.model.Vehicle;
import com.vehicleManagementTool.Backend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import  org.springframework.data.rest.webmvc.ResourceNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceProvider implements VehicleService{


    private VehicleRepository vehicleRepository;
    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOS = vehicles.stream().map(vehicle -> VehicleMapper.mapToVehicleDTO(vehicle))
                .collect(Collectors.toList());
        return vehicleDTOS;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDTO(savedVehicle);
    }

    @Override
    public VehicleDTO getVehicleById(long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle does not exist with id: " + vehicleId));
        VehicleDTO vehicleDTO = VehicleMapper.mapToVehicleDTO(vehicle);
        return vehicleDTO;
    }

    @Override
    public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicleDTO) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not exist with id: " + vehicleId));

        existingVehicle.setBrand(vehicleDTO.getBrand());
        existingVehicle.setModel(vehicleDTO.getModel());
        existingVehicle.setConditionVehicle(vehicleDTO.getConditionVehicle());
        existingVehicle.setMileage(vehicleDTO.getMileage());
        existingVehicle.setConstructionOfYear(vehicleDTO.getConstructionOfYear());
        existingVehicle.setFuelKind(vehicleDTO.getFuelKind());

        vehicleRepository.save(existingVehicle);
        return VehicleMapper.mapToVehicleDTO(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long vehicleId) {

        Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not exist with id: " + vehicleId));

        vehicleRepository.deleteById(vehicleId);
    }
}
