package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private long id = 0;

    public Ticket save(Ticket ticket){
        id += 1;
        ticket.setId(id);
        tickets.put(id,ticket);
        return ticket;
    }
}
