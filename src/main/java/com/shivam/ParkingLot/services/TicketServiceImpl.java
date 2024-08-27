package com.shivam.ParkingLot.services;

import com.shivam.ParkingLot.exceptions.GateNotFoundException;
import com.shivam.ParkingLot.exceptions.OperatorNotFoundException;
import com.shivam.ParkingLot.models.*;
import com.shivam.ParkingLot.repositories.*;
import com.shivam.ParkingLot.strategies.SlotAssignmentStrategy;
import com.shivam.ParkingLot.strategies.SlotAssignmentStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {
    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private OperatorRepository operatorRepository;
    private TicketRepository ticketRepository;
    private ParkingSlotRepository parkingSlotRepository;

    public TicketServiceImpl(VehicleRepository vehicleRepository,
                             GateRepository gateRepository,
                             OperatorRepository operatorRepository,
                             TicketRepository ticketRepository,
                             ParkingSlotRepository parkingSlotRepository){
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public Ticket generateTicket(Long gateId, Long operatorId, String licensePlateNumber, VehicleType vehicleType) {
        Ticket ticket = new Ticket();
        /*
        * Set the vehicle
        *   - check if the vehicle with this licensePlateNumber is present in DB or not
        *   - if present -> add the vehicle in the ticket
        *   - if not -> first add the vehicle in the DB then in the ticket
        * */

        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByLicensePlateNumber(licensePlateNumber);

        Vehicle savedVehicle = null;
        if (optionalVehicle.isPresent()){
            savedVehicle = optionalVehicle.get();
        } else {
            // save the vehicle in the db
            Vehicle vehicle = new Vehicle();
            vehicle.setLicensePlateNumber(licensePlateNumber);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(savedVehicle);

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
        /*
         * Find a parking slot for provide vehicle type
         * Mark the slot as FILLED
         * save the changes to the db
         * add the parking slot in the ticket
         */
        ParkingLot parkingLot = gate.getParkingLot();
        SlotAssignmentStrategy slotAssignmentStrategy = SlotAssignmentStrategyFactory.
                getSlotAssignmentStrategyByType(parkingLot.getSlotAssignmentStrategyType());

        ParkingSlot parkingSlot = slotAssignmentStrategy.findSlot(
                gate.getParkingLot(),
                savedVehicle.getVehicleType()
        );
        parkingSlot.setParkingSlotStatus(ParkingSlotStatus.FILLED);

        ParkingSlot saveParkingSlot = parkingSlotRepository.save(parkingSlot);

        ticket.setParkingSlot(saveParkingSlot);

        return ticketRepository.save(ticket);
    }
}
