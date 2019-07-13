package com.obss.abstraction;

import com.obss.arayuz.ICar;

public abstract class AbstractCar implements ICar {

    public void drive() {
        System.out.println("Drive method triggered");
    }

    public abstract void stop();


    @Override
    public void brake() {
        System.out.println("Brake the car");
    }
}
