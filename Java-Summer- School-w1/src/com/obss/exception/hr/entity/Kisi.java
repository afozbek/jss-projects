package com.obss.exception.hr.entity;

public class Kisi {

    private int tcKimlikNo;
    private String name;
    private String surname;
    private int experience;
    private double salary;

    public Kisi() {
    }

    public Kisi(int tcKimlikNo, String name, String surname, int experience) {
        this.tcKimlikNo = tcKimlikNo;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public int getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(int tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "tcKimlikNo=" + tcKimlikNo +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }
}
