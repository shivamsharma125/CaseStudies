package com.shivam.ParkingLot.models;

public class Gate extends BaseModel {
    private String gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator operator;
    private ParkingLot parkingLot;

    public Gate(String gateNumber, GateType gateType, GateStatus gateStatus, Operator operator, ParkingLot parkingLot) {
        this.gateNumber = gateNumber;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
        this.operator = operator;
        this.parkingLot = parkingLot;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
