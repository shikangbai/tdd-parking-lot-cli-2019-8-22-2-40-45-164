package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private List parkingTicketsList = new ArrayList<ParkingTicket>();;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
    	ParkingTicket pTicket = parkingLot.parkCar(car);
    	if(pTicket != null) {
    		this.lastErrorMessage = null;
    	}else {
    		this.lastErrorMessage = "The parking lot is full.";
    		return null;
    	}
       return pTicket;
    }

    public Car fetch(ParkingTicket ticket) {
    	if(ticket == null) {
    		this.lastErrorMessage = "Please provide your parking ticket.";
    		return null;
    	}else if(parkingTicketsList.contains(ticket)) {
    		this.lastErrorMessage = "Unrecognized parking ticket.";
    		return null;
    	}
    	Car car = parkingLot.pickCar(ticket);
    	if(car == null) {
    		this.lastErrorMessage = "Unrecognized parking ticket.";
    		return null;
    	}
    	parkingTicketsList.add(ticket);
       return car;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
