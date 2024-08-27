package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.ParkingSlot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingSlotRepositoryImpl implements ParkingSlotRepository {
    private Map<Long, ParkingSlot> parkingSlots = new TreeMap<>();
    private long id = 0;

    public ParkingSlot save(ParkingSlot parkingSlot){
        if (parkingSlot.getId() == 0){
            id += 1;
            parkingSlot.setId(id);
        }
        parkingSlots.put(parkingSlot.getId(), parkingSlot);
        return parkingSlot;
    }
}
