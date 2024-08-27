package com.shivam.ParkingLot.models;

import java.util.List;

public class ParkingSlot extends BaseModel {
    private String slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private List<VehicleType> vehicleTypes;

    public ParkingSlot(String slotNumber, ParkingSlotStatus parkingSlotStatus, List<VehicleType> vehicleTypes) {
        this.slotNumber = slotNumber;
        this.parkingSlotStatus = parkingSlotStatus;
        this.vehicleTypes = vehicleTypes;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
