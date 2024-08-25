package com.shivam.ParkingLot.exceptions;

public class OperatorNotFoundException extends RuntimeException {
    public OperatorNotFoundException(Long operatorId){
        super("Operator with id " + operatorId + " is not present in the DB.");
    }
}
