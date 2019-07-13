package com.obss.bus_reservation;

import java.util.Arrays;

public class Bus {

    private Destination destination;
    private Passenger[] passengers;

    private int passengersCount;

    public Bus(Destination destination, Passenger[] passengers) {
        this.destination = destination;
        this.passengers = passengers;
        passengersCount = 0;
    }


    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[] passengers) {
        this.passengers = passengers;
    }

    public void insertPassenger(Passenger passenger) {

        if (passengersCount == getPassengers().length) {
            System.out.println("Capacity is full");
            return;
        }
        passengers[passengersCount] = passenger;
        System.out.println("Passenger is added : " + passenger);
        passengersCount++;
    }

}
