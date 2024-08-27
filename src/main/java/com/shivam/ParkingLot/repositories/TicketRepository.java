package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Ticket;

public interface TicketRepository {
    Ticket save(Ticket ticket);
}
