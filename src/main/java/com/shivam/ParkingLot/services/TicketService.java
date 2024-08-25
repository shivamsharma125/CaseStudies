package com.shivam.ParkingLot.services;

import com.shivam.ParkingLot.models.Ticket;
import com.shivam.ParkingLot.models.VehicleType;

public interface TicketService {
    Ticket generateTicket(Long gateId, Long operatorId, String licensePlateNumber, VehicleType vehicleType);
}
