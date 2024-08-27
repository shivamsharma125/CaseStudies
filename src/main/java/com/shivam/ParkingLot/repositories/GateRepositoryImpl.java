package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepositoryImpl implements GateRepository {
    private Map<Long, Gate> gates = new TreeMap<>();
    private long id = 0;

    public Optional<Gate> findGateById(Long gateId) {
        Gate gate = gates.get(gateId);
        return Optional.ofNullable(gate);
    }

    public Gate save(Gate gate) {
        if (gate.getId() == 0){
            id += 1;
            gate.setId(id);
        }
        gates.put(gate.getId(), gate);
        return gate;
    }
}
