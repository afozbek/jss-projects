package com.obss.polymorphism;

public class Lion extends Animal {

    public String name;

    @Override
    public void makeNoise() {
        System.out.println("Rooaarrr!!");
    }

    public static void staticRedefineMethod() {

    }

    // You can not override final methods
   // protected void notModifiableMethod() {}

    // You can not re-declare static methods as instance methods.
    //public void staticRedefineMethod() {}

    public static void main(String[] args) {

    }


}
