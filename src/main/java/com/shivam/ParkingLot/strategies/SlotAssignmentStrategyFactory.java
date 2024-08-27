package com.shivam.ParkingLot.strategies;

import com.shivam.ParkingLot.models.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategyByType(
            SlotAssignmentStrategyType slotAssignmentStrategyType){
        if (SlotAssignmentStrategyType.RANDOM.equals(slotAssignmentStrategyType)){
            return new RandomSlotAssignmentStrategy();
        }
        return null;
    }
}
