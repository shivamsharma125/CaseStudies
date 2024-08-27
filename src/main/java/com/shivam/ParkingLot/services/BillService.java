package com.shivam.ParkingLot.services;

import com.shivam.ParkingLot.exceptions.GateNotFoundException;
import com.shivam.ParkingLot.exceptions.OperatorNotFoundException;
import com.shivam.ParkingLot.exceptions.PaymentNotFoundException;
import com.shivam.ParkingLot.exceptions.TicketNotFoundException;
import com.shivam.ParkingLot.models.Bill;

import java.util.Date;
import java.util.List;

public interface BillService {
    Bill generateBill(Date exitTime, long gateId, long operatorId, long ticketId, int amount,
                      List<Long> paymentIds) throws GateNotFoundException, OperatorNotFoundException,
            TicketNotFoundException, PaymentNotFoundException;
}
