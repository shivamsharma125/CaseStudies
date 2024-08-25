package com.shivam.ParkingLot.strategies;

import com.shivam.ParkingLot.models.ParkingSlot;
import com.shivam.ParkingLot.models.Vehicle;

public interface SlotAssignmentStrategy {
    ParkingSlot assignSlot(Vehicle vehicle);
}
