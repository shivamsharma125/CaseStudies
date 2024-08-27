package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Gate;

import java.util.Optional;

public interface GateRepository {
    Optional<Gate> getGateById(Long gateId);
    Gate save(Gate gate);
}
