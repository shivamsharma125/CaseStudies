package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Operator;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class OperatorRepositoryImpl implements OperatorRepository {
    private Map<Long, Operator> operators = new TreeMap<>();
    private long id = 0;

    public Optional<Operator> findOperatorById(Long operatorId){
        Operator operator = operators.get(operatorId);
        return Optional.ofNullable(operator);
    }

    public Operator save(Operator operator){
        if (operator.getId() == 0){
            id += 1;
            operator.setId(id);
        }
        operators.put(operator.getId(),operator);
        return operator;
    }
}
