package com.shivam.ParkingLot.services;

import com.shivam.ParkingLot.exceptions.GateNotFoundException;
import com.shivam.ParkingLot.exceptions.OperatorNotFoundException;
import com.shivam.ParkingLot.exceptions.VehicleNotFoundException;
import com.shivam.ParkingLot.models.*;
import com.shivam.ParkingLot.repositories.GateRepository;
import com.shivam.ParkingLot.repositories.OperatorRepository;
import com.shivam.ParkingLot.repositories.TicketRepository;
import com.shivam.ParkingLot.repositories.VehicleRepository;
import com.shivam.ParkingLot.strategies.SlotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {
    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private OperatorRepository operatorRepository;
    private SlotAssignmentStrategy slotAssignmentStrategy;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(VehicleRepository vehicleRepository,
                             GateRepository gateRepository,
                             OperatorRepository operatorRepository,
                             SlotAssignmentStrategy slotAssignmentStrategy,
                             TicketRepository ticketRepository){
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateTicket(Long vehicleId, Long gateId, Long operatorId) {
        Ticket ticket = new Ticket();
        /*
        * Set the vehicle
        *   - check if the vehicle with this vehicleId is present in DB or not
        *   - if present -> add the vehicle in the ticket
        *   - if not -> first add the vehicle in the DB then in the ticket
        * */

        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleById(vehicleId);

        if (optionalVehicle.isEmpty()){
            throw new VehicleNotFoundException(vehicleId);
        }

        Vehicle vehicle = optionalVehicle.get();
        ticket.setVehicle(vehicle);

        // Set time
        ticket.setEntryTime(new Date());

        // Set the gate
        Optional<Gate> optionalGate = gateRepository.getGateById(gateId);

        if (optionalGate.isEmpty()){
            throw new GateNotFoundException(gateId);
        }

        Gate gate = optionalGate.get();
        ticket.setGate(gate);

        // Set the operator
        Optional<Operator> optionalOperator = operatorRepository.getOperatorById(operatorId);

        if (optionalOperator.isEmpty()){
            throw new OperatorNotFoundException(operatorId);
        }

        Operator operator = optionalOperator.get();
        ticket.setOperator(operator);

        // Parking slot
        ParkingSlot parkingSlot = slotAssignmentStrategy.assignSlot(vehicle);
        ticket.setParkingSlot(parkingSlot);

        return ticketRepository.save(ticket);
    }
}
