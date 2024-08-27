package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Ticket;

import java.util.Optional;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Optional<Ticket> findTicketById(long ticketId);
}
