package com.obss.bus_reservation;

public class PassengerTest {

    public static void main(String[] args) {
        Passenger x = new Passenger("obss", Destination.ANKARA);
        Passenger y = new Passenger("obss", Destination.ANKARA);


        System.out.println(x.equals(y));
    }
}
