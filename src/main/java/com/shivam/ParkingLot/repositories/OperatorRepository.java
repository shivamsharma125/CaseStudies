package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Operator;

import java.util.Optional;

public interface OperatorRepository {
    Optional<Operator> findOperatorById(Long operatorId);
    Operator save(Operator operator);
}
