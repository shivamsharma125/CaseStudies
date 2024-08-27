package com.shivam.ParkingLot.controllers;

import com.shivam.ParkingLot.dtos.GenerateBillRequestDto;
import com.shivam.ParkingLot.dtos.GenerateBillResponseDto;
import com.shivam.ParkingLot.dtos.ResponseStatus;
import com.shivam.ParkingLot.models.Bill;
import com.shivam.ParkingLot.services.BillService;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public GenerateBillResponseDto generateBill(GenerateBillRequestDto requestDto) {
        GenerateBillResponseDto responseDto = new GenerateBillResponseDto();

        try {
            Bill bill = billService.generateBill(
                    requestDto.getExitTime(),
                    requestDto.getGateId(),
                    requestDto.getOperatorId(),
                    requestDto.getTicketId(),
                    requestDto.getAmount(),
                    requestDto.getPaymentIds()
            );
            responseDto.setBillId(bill.getId());
            responseDto.setAmount(bill.getAmount());
            responseDto.setEntryTime(bill.getTicket().getEntryTime());
            responseDto.setExitTime(bill.getExitTime());
            responseDto.setVehicleType(bill.getTicket().getVehicle().getVehicleType());
            responseDto.setGateNumber(bill.getTicket().getGate().getGateNumber());
            responseDto.setLicensePlateNumber(bill.getTicket().getVehicle().getLicensePlateNumber());
            responseDto.setOperatorName(bill.getOperator().getName());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setFailureMessage(ex.getMessage());
        }

        return responseDto;
    }
}
