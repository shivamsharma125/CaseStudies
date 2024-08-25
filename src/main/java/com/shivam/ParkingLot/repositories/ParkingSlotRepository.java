package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkingSlotRepository {
    private Map<Long, ParkingSlot> parkingSlots = new TreeMap<>();
    private long id = 0;

    public ParkingSlot save(ParkingSlot parkingSlot){
        id += 1;
        parkingSlot.setId(id);
        parkingSlots.put(id,parkingSlot);
        return parkingSlot;
    }

    public List<ParkingSlot> getAllParkingSlots(){
        return new ArrayList<>(parkingSlots.values());
    }
}
