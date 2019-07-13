package com.obss.constructor;


public class StudentTest {

    public static void main(String[] args) {
        SabanciStudent student = new SabanciStudent("obss");



        SabanciStudent studentSecond = new SabanciStudent("turkcell");


        SabanciStudent studentThird = student;


        studentThird.setName("Degistirdim");

        System.out.println(student.getName());

        com.obss.checker.RandomChecker checker = new com.obss.checker.RandomChecker();




    }
}
