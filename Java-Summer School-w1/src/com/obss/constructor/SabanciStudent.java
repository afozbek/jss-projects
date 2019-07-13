package com.obss.constructor;

public class SabanciStudent {

    private String name;


    public static void main(String[] args) {


    }

    public SabanciStudent() {
        System.out.println("Default constructor");
    }

    public SabanciStudent(String name) {
        this();
        this.name = name;
    }

    public SabanciStudent(String name, int yas) {
        this(name);
        System.out.println("Yasi : " + yas);
    }

    public void nonReturnableMethod() {
        System.out.println("Non returnable method");
    }

    public String getName() {
        System.out.println("Getter of name is triggered!");
        return "Sr" + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverage(String x, int y) {
        return 0;
    }

    public double getAverage(int x, String y) {
        return 0.0;
    }
}
