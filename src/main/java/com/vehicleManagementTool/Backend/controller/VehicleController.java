package com.vehicleManagementTool.Backend.controller;

import com.vehicleManagementTool.Backend.DTO.VehicleDTO;
import com.vehicleManagementTool.Backend.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/vehicle_table")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    // build create vehicle REST API
    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicle) {
        VehicleDTO vehicleDTO = vehicleService.createVehicle(vehicle);
        return new ResponseEntity<>(vehicleDTO, HttpStatus.CREATED);
    }

    // build get vehicle by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable("id") Long vehicleId){
        VehicleDTO vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok(vehicle);
    }

    // build update vehicle REST API
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable("id") Long vehicleId,
                                                      @RequestBody VehicleDTO vehicleDetails) {
        VehicleDTO updateVehicle = vehicleService.updateVehicle(vehicleId, vehicleDetails);
        return ResponseEntity.ok(updateVehicle);
    }

    // build delete vehicle REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle deleted successfully!");
    }
}
