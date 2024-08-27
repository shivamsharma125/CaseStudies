package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Vehicle;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepositoryImpl implements VehicleRepository {
    private Map<Long, Vehicle> vehicles = new TreeMap<>();
    private long id = 0;

    public Optional<Vehicle> getVehicleByLicensePlateNumber(String licensePlateNumber){
        for (Vehicle vehicle : vehicles.values()){
            if (vehicle.getLicensePlateNumber().equals(licensePlateNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        if (vehicle.getId() == 0){
            id += 1;
            vehicle.setId(id);
        }
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}
