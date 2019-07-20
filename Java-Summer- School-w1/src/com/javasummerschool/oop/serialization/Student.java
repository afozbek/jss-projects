package com.javasummerschool.oop.serialization;

import java.io.Serializable;


public class Student implements Serializable {
    private String name;
    private String surname;
    private transient Teacher teacher;
    private transient String nationalSecurityNumber;
    private transient School school;

    public Student() {
        this.name = "";
        this.surname = "";
        this.teacher = new Teacher();
        this.school = school;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Getter-Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getNationalSecurityNumber() {
        return nationalSecurityNumber;
    }

    public void setNationalSecurityNumber(String nationalSecurityNumber) {
        this.nationalSecurityNumber = nationalSecurityNumber;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
