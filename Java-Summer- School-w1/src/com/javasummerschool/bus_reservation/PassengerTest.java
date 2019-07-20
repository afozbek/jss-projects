package com.javasummerschool.bus_reservation;

public class PassengerTest {

    public static void main(String[] args) {
        Passenger x = new Passenger("javasummerschool", Destination.ANKARA);
        Passenger y = new Passenger("javasummerschool", Destination.ANKARA);


        System.out.println(x.equals(y));
    }
}
