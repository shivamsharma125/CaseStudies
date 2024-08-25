package com.shivam.ParkingLot.exceptions;

public class GateNotFoundException extends RuntimeException {
    public GateNotFoundException(Long gateId){
        super("Gate with id " + gateId + " is not present in the DB.");
    }
}
