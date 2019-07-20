package com.javasummerschool.java_bean;

import java.io.Serializable;

public class Lesson implements Serializable {

    private int lessonId;
    private String name;
    private int age;
    private double gpa;

    public Lesson(int lessonId, String name, int age, double gpa) {
        this.lessonId = lessonId;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Getter Setters

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
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
        Lesson lesson = new Lesson(1,"Recep", 23, 3.0);

        lesson.setAge(23);
        lesson.setGpa(3.0);
        lesson.setName("Recep");
    }
}
