package com.obss.oop.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/tmp/serialUID.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student student = (Student) ois.readObject();

        System.out.println("Student name : " + student.getName());
        System.out.println("Student surname : " + student.getSurname());
        System.out.println("Student teacher value : " + student.getTeacher());
    }
}
