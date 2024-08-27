package com.shivam.ParkingLot.strategies;

import com.shivam.ParkingLot.models.*;
import com.shivam.ParkingLot.repositories.ParkingSlotRepositoryImpl;

import java.util.List;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {
    @Override
    public ParkingSlot findSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlots()){
                if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY) &&
                    parkingSlot.getVehicleTypes().contains(vehicleType)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
