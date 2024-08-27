package com.shivam.ParkingLot.models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private String floorNumber;
    private ParkingFloorStatus parkingFloorStatus;
    private List<VehicleType> vehicleTypes;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(String floorNumber, ParkingFloorStatus parkingFloorStatus, List<VehicleType> vehicleTypes, List<ParkingSlot> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingFloorStatus = parkingFloorStatus;
        this.vehicleTypes = vehicleTypes;
        this.parkingSlots = parkingSlots;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
