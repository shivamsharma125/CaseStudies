package com.shivam.ParkingLot.services;

import com.shivam.ParkingLot.models.Ticket;

public interface TicketService {
    Ticket generateTicket(Long vehicleId, Long gateId, Long operatorId);
}
