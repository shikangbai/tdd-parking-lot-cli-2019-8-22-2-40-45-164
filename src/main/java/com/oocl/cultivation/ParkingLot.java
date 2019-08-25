package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<>();

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableParkingPosition() {
        return cars.size() - capacity;
    }
    
    public ParkingTicket parkCar(Car car) {
    	int position = this.getAvailableParkingPosition();
    	if(position >= 0) {
    		return null;
    	}
    	ParkingTicket pTicket =new ParkingTicket();
    	cars.put(pTicket, car);
    	return pTicket;
    }
    public Car pickCar(ParkingTicket pTicket) {
    	Car car = cars.get(pTicket);
    	if(car == null) {
    		return null;
    	}
    	return car;
    }
}
