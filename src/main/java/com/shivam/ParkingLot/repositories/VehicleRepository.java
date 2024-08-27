package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Vehicle;

import java.util.Optional;

public interface VehicleRepository {
    Optional<Vehicle> getVehicleByLicensePlateNumber(String licensePlateNumber);
    Vehicle save(Vehicle vehicle);
}
