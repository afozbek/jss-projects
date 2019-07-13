package com.obss.bus_reservation;

public class BusTest {

    public static void main(String[] args) {

        Destination destination = Destination.ANKARA;

        Passenger[] passengers = new Passenger[4];

        Bus bus = new Bus(destination, passengers);

        bus.insertPassenger(new Passenger("ali", destination));
        bus.insertPassenger(new Passenger("veli", destination));
        bus.insertPassenger(new Passenger("ahmet", destination));
        bus.insertPassenger(new Passenger("cenk", destination));

        bus.insertPassenger(new Passenger("emre", destination));
        bus.insertPassenger(new Passenger("samet", destination));


    }

}

