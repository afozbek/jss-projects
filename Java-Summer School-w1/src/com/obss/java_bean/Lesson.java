package com.obss.java_bean;

import java.io.Serializable;
import java.util.EventListener;

public class Lesson implements Serializable {

    private String name;
    private int age;
    private double gpa;

    public Lesson() {
        this("", 0, 0.0);
    }

    public Lesson(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static void main(String[] args) {
        Lesson lesson = new Lesson();
        lesson.setAge(23);
        lesson.setGpa(3.0);
        lesson.setName("Recep");

        Lesson recep = new Lesson("Recep", 23, 3.0);
    }
}
