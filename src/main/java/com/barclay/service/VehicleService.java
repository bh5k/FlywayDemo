package com.barclay.service;

import com.barclay.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAllVehicles();

    Vehicle save(Vehicle vehicle);
}
