package com.obss.arayuz;

public class InterfaceTest {

    public static void main(String[] args) {
        ILuxury luxury = new BmwCar();

        ICar car = new BmwCar();

        luxury.openSunroof();

        car.brake();
        ICar.staticInterfaceMethod();

        ICar germanCar = new GermanCar();
        germanCar.defaultInterfaceMethod();

        ICar turkishCar = new TurkishCar();




    }
}
