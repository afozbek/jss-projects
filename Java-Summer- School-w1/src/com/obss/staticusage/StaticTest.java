package com.obss.staticusage;

class StaticTest {

    public void yaz() {
        System.out.println(Student.notOrtalamasi);

        StudentNotStatic object = new StudentNotStatic();


        Student.mezunOl();


    }

    public static void main(String[] args) {

        System.out.println(Student.notOrtalamasi);

        Student x = new Student();
        Student.notOrtalamasi = 3.0;

        System.out.println(Student.notOrtalamasi);



        // Multiple Constructor Tests

        StudentNotStatic student1 = new StudentNotStatic(23);


    }
}
