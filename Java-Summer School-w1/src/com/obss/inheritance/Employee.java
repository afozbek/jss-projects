package com.obss.inheritance;

public class Employee {

    protected double maas;


    public Employee() {
        System.out.println("This is a Employee Constructor");
        this.maas = 0.0;
    }

    public Employee(double maas) {
        System.out.println("Parent Constructor");
        this.maas = maas;
    }


    public void parentMethod() {
        System.out.println("Initial method");
    }

    public void commonMethod() {
        System.out.println("This is a employee method");
    }

}
