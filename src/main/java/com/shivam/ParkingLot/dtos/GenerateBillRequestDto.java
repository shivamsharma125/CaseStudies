package com.shivam.ParkingLot.dtos;

import java.util.Date;
import java.util.List;

public class GenerateBillRequestDto {
    private Date exitTime;
    private long gateId;
    private long operatorId;
    private long ticketId;
    private int amount;
    private List<Long> paymentIds;

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }

    public long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Long> getPaymentIds() {
        return paymentIds;
    }

    public void setPaymentIds(List<Long> paymentIds) {
        this.paymentIds = paymentIds;
    }
}
