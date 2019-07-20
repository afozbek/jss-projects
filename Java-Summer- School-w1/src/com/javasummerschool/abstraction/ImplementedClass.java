package com.javasummerschool.abstraction;

public class ImplementedClass extends AbstractClass {

    public static void main(String[] args) {
        AbstractClass abstractClass = new ImplementedClass();
        abstractClass.writeToOutput();
    }

    @Override
    public void writeToOutput() {
        System.out.println("Hello World");
    }

}
