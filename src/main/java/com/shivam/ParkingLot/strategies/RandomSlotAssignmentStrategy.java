package com.shivam.ParkingLot.strategies;

import com.shivam.ParkingLot.models.*;
import com.shivam.ParkingLot.repositories.ParkingSlotRepository;

import java.util.List;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {
    private ParkingSlotRepository parkingSlotRepository;

    public RandomSlotAssignmentStrategy(ParkingSlotRepository parkingSlotRepository){
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public ParkingSlot findSlot(VehicleType vehicleType) {
        List<ParkingSlot> parkingSlots = parkingSlotRepository.getAllParkingSlots();
        for(ParkingSlot parkingSlot : parkingSlots){
            for (SupportedVehicleType parkingSlotVehicleType : parkingSlot.getVehicleTypes()){
                if (parkingSlotVehicleType.getVehicleType().equals(vehicleType) &&
                    parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
