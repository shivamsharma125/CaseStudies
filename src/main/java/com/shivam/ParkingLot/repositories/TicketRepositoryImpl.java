package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepositoryImpl implements TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private long id = 0;

    public Ticket save(Ticket ticket){
        if (ticket.getId() == 0){
            id += 1;
            ticket.setId(id);
        }
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }
}
