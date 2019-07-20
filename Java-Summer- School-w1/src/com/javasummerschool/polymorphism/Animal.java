package com.javasummerschool.polymorphism;

public class Animal {

    public void makeNoise() {
        System.out.println("No sound");
    }

    public static void staticRedefineMethod() {
       // You can not call instance method from static methods.
        // instanceMethod();

    }

    public void instanceMethod() {
        System.out.println("Instance method");
    }

    protected void protectedMethod() {

    }

    protected final void notModifiableMethod() {

    }
}
