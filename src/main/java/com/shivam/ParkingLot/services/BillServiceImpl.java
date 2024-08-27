package com.shivam.ParkingLot.services;

import com.shivam.ParkingLot.exceptions.GateNotFoundException;
import com.shivam.ParkingLot.exceptions.OperatorNotFoundException;
import com.shivam.ParkingLot.exceptions.PaymentNotFoundException;
import com.shivam.ParkingLot.exceptions.TicketNotFoundException;
import com.shivam.ParkingLot.models.*;
import com.shivam.ParkingLot.repositories.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BillServiceImpl implements BillService {
    private GateRepository gateRepository;
    private OperatorRepository operatorRepository;
    private TicketRepository ticketRepository;
    private PaymentRepository paymentRepository;
    private BillRepository billRepository;

    public BillServiceImpl(GateRepository gateRepository,
                           OperatorRepository operatorRepository,
                           TicketRepository ticketRepository,
                           PaymentRepository paymentRepository,
                           BillRepository billRepository){
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
        this.ticketRepository = ticketRepository;
        this.paymentRepository = paymentRepository;
        this.billRepository = billRepository;
    }

    @Override
    public Bill generateBill(Date exitTime, long gateId, long operatorId, long ticketId, int amount, List<Long> paymentIds) throws GateNotFoundException, OperatorNotFoundException, TicketNotFoundException, PaymentNotFoundException {
        Bill bill = new Bill();

        bill.setExitTime(exitTime);

        /*
            1. Check if a gate with this gateId is present in the DB or not
            2. If not present -> throw exception
            3. If present -> get the Gate object from DB
            4. Set it in the bill object
         */
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if (optionalGate.isEmpty()){
            throw new GateNotFoundException("Gate with id " + gateId + " is not present in db.");
        }

        Gate gate = optionalGate.get();
        bill.setGate(gate);

        // set the Operator
        Optional<Operator> optionalOperator = operatorRepository.findOperatorById(operatorId);

        if (optionalOperator.isEmpty()){
            throw new OperatorNotFoundException("Operator with id " + operatorId + " does not exist.");
        }

        Operator operator = optionalOperator.get();
        bill.setOperator(operator);

        // Set the ticket
        Optional<Ticket> optionalTicket = ticketRepository.findTicketById(ticketId);

        if (optionalTicket.isEmpty()){
            throw new TicketNotFoundException("ticket with id " + ticketId + " does not exist");
        }

        Ticket ticket = optionalTicket.get();
        bill.setTicket(ticket);

         // Set the amount
         bill.setAmount(amount);

         // Set all the payments in a list
        List<Payment> payments = new ArrayList<>();

        for (Long paymentId : paymentIds){
            Optional<Payment> optionalPayment = paymentRepository.findPaymentById(paymentId);

            if (optionalPayment.isEmpty()){
                throw new PaymentNotFoundException("payment with id " + paymentId + " does not exist");
            }

            Payment payment = optionalPayment.get();
            payments.add(payment);
        }

        bill.setPayments(payments);

        // Save the bill in the db
        return billRepository.save(bill);
    }
}
