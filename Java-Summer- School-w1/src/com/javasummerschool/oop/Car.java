package com.javasummerschool.oop;

public class Car {
    private static String color = "Red";
    private static int capacity = 5;


    void moveForward() {
        System.out.println("Moving Forward with capacity : " + capacity);

        int tempValue = 0;

        //accelerate();
        //injectGasoline();
    }

    void introduce(){

    }

    static int getCapacity(){
        return capacity;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        capacity = 7;
        System.out.println("Car 2 capacity: " + capacity);

        System.out.println("Car 1 capacity: " + capacity);

        car1.moveForward();

        int capacity = getCapacity();
        car2.moveForward();
    }

    private class HackedClass {

    }
}
