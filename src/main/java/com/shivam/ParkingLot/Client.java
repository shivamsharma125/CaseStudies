package com.shivam.ParkingLot;

import com.shivam.ParkingLot.controllers.TicketController;
import com.shivam.ParkingLot.dtos.GenerateTicketRequestDto;
import com.shivam.ParkingLot.dtos.GenerateTicketResponseDto;
import com.shivam.ParkingLot.dtos.ResponseStatus;
import com.shivam.ParkingLot.models.*;
import com.shivam.ParkingLot.repositories.*;
import com.shivam.ParkingLot.services.TicketService;
import com.shivam.ParkingLot.services.TicketServiceImpl;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepositoryImpl();
        OperatorRepository operatorRepository = new OperatorRepositoryImpl();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepositoryImpl();
        TicketRepository ticketRepository = new TicketRepositoryImpl();
        VehicleRepository vehicleRepository = new VehicleRepositoryImpl();

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setSlotAssignmentStrategyType(SlotAssignmentStrategyType.RANDOM);

        Operator operator1 = new Operator("Operator1", "op1@gmail.com", "9090909090");
        Operator operator2 = new Operator("Operator2", "op2@gmail.com", "9090909090");
        operatorRepository.save(operator1);
        operatorRepository.save(operator2);

        Gate gate1 = new Gate("Gate1", GateType.ENTRY, GateStatus.OPEN, operator1, parkingLot);
        Gate gate2 = new Gate("Gate2", GateType.EXIT, GateStatus.OPEN, operator2, parkingLot);
        gateRepository.save(gate1);
        gateRepository.save(gate2);

        VehicleType vehicleTypeTwoWheeler = new VehicleType("TWO_WHEELER");
        VehicleType vehicleTypeFourWheeler = new VehicleType("FOUR_WHEELER");

        ParkingSlot parkingSlot1 = new ParkingSlot(
                "Slot1",
                ParkingSlotStatus.EMPTY,
                List.of(vehicleTypeTwoWheeler)
        );
        ParkingSlot parkingSlot2 = new ParkingSlot(
                "Slot2",
                ParkingSlotStatus.EMPTY,
                List.of(vehicleTypeFourWheeler)
        );
        parkingSlotRepository.save(parkingSlot1);
        parkingSlotRepository.save(parkingSlot2);

        ParkingFloor parkingFloor = new ParkingFloor(
                "F1",
                ParkingFloorStatus.OPEN,
                List.of(vehicleTypeTwoWheeler,vehicleTypeFourWheeler),
                List.of(parkingSlot1,parkingSlot2)
        );
        parkingLot.setParkingFloors(List.of(parkingFloor));

        TicketService ticketService = new TicketServiceImpl(
                vehicleRepository,
                gateRepository,
                operatorRepository,
                ticketRepository,
                parkingSlotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setGateId(1);
        requestDto.setOperatorId(1);
        requestDto.setVehicleType(new VehicleType("FOUR_WHEELER"));
        requestDto.setLicensePlateNumber("DL123");

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);

        if (responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println("Ticket issued. Slot number: " + responseDto.getParkingSlotNumber());
        }
        else {
            System.out.println("Error occurred while issuing ticket: " + responseDto.getFailureMessage());
        }
    }
}
