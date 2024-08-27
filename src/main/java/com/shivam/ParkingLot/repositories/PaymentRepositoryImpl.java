package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Payment;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PaymentRepositoryImpl implements PaymentRepository {
    private Map<Long,Payment> payments = new TreeMap<>();
    private long id = 0;
    @Override
    public Optional<Payment> findPaymentById(long paymentId) {
        Payment payment = payments.get(paymentId);
        return Optional.ofNullable(payment);
    }

    @Override
    public Payment save(Payment payment) {
        id += 1;
        payment.setId(id);
        payments.put(payment.getId(), payment);
        return payment;
    }
}
