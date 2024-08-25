package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {
    private Map<Long, Gate> gates = new TreeMap<>();
    private long id = 0;

    public Optional<Gate> getGateById(Long gateId) {
        Gate gate = gates.get(gateId);
        return Optional.of(gate);
    }

    public Gate save(Gate gate) {
        id = id + 1;
        gate.setId(id);
        gates.put(id, gate);
        return gate;
    }
}
