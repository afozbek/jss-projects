package com.obss.arayuz;

public interface ICar {
    public static final int DOOR_NUMBER = 4;


    void drive();
    void stop();
    void brake();


    static void staticInterfaceMethod(){
        System.out.println("This is a interface static method.");
    }

    default void defaultInterfaceMethod() {
        System.out.println("This is a interface default method");
    }
}
