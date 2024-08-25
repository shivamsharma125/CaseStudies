package com.shivam.ParkingLot.controllers;

import com.shivam.ParkingLot.dtos.GenerateTicketRequestDto;
import com.shivam.ParkingLot.dtos.GenerateTicketResponseDto;
import com.shivam.ParkingLot.dtos.ResponseStatus;
import com.shivam.ParkingLot.models.Ticket;
import com.shivam.ParkingLot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();

        try{
            Ticket ticket = ticketService.generateTicket(
                    requestDto.getVehicleId(),
                    requestDto.getGateId(),
                    requestDto.getOperatorId()
            );
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setFailureMessage(ex.getMessage());
        }

        return responseDto;
    }
}
