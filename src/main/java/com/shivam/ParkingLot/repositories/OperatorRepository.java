package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Gate;
import com.shivam.ParkingLot.models.Operator;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class OperatorRepository {
    private Map<Long, Operator> operators = new TreeMap<>();
    private long id = 0;

    public Optional<Operator> getOperatorById(Long operatorId){
        Operator operator = operators.get(operatorId);
        return Optional.of(operator);
    }

    public Operator save(Operator operator){
        id += 1;
        operator.setId(id);
        operators.put(id,operator);
        return operator;
    }
}
