package com.shivam.ParkingLot.dtos;

import com.shivam.ParkingLot.models.Ticket;

public class GenerateTicketResponseDto extends BaseResponseDto {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
