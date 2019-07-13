package com.obss.bus_reservation;

public class Passenger {

    private String name;
    private Destination destination;

    public Passenger(String name, Destination destionation) {
        this.name = name;
        this.destination = destionation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Passenger passenger = (Passenger) obj;
        return this.name.equals(passenger.getName()) && this.destination == passenger.getDestination();
    }
}
