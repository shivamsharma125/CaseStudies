package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Payment;

import java.util.Optional;

public interface PaymentRepository {
    Optional<Payment> findPaymentById(long paymentId);
    Payment save(Payment payment);
}
