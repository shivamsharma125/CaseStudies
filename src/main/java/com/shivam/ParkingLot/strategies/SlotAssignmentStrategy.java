package com.shivam.ParkingLot.strategies;

import com.shivam.ParkingLot.models.ParkingSlot;
import com.shivam.ParkingLot.models.Vehicle;
import com.shivam.ParkingLot.models.VehicleType;

public interface SlotAssignmentStrategy {
    ParkingSlot findSlot(VehicleType vehicleType);
}
