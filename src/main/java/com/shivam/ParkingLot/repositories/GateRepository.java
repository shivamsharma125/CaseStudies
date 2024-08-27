package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Gate;

import java.util.Optional;

public interface GateRepository {
    Optional<Gate> findGateById(Long gateId);
    Gate save(Gate gate);
}
