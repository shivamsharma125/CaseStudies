package com.shivam.ParkingLot.repositories;

import com.shivam.ParkingLot.models.Bill;

import java.util.Map;
import java.util.TreeMap;

public class BillRepositoryImpl implements BillRepository {
    private Map<Long,Bill> bills = new TreeMap<>();
    private long id = 0;
    @Override
    public Bill save(Bill bill) {
        id += 1;
        bill.setId(id);
        bills.put(id,bill);
        return bill;
    }
}
