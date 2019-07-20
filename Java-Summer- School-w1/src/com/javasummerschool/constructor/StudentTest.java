package com.javasummerschool.constructor;


public class StudentTest {

    public static void main(String[] args) {
        SabanciStudent student = new SabanciStudent("javasummerschool");


        SabanciStudent studentSecond = new SabanciStudent("turkcell");


        SabanciStudent studentThird = student;


        studentThird.setName("Degistirdim");

        System.out.println(student.getName());

        com.javasummerschool.checker.RandomChecker checker = new com.javasummerschool.checker.RandomChecker();


    }
}
