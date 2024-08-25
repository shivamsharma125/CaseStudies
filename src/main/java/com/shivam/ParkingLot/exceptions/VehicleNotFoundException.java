package com.shivam.ParkingLot.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(Long vehicleId){
        super("Vehicle with id " + vehicleId + " is not present in the DB.");
    }
}
