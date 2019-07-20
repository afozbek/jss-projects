package com.javasummerschool.oop.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest implements Serializable {

    public static void main(String[] args) throws IOException {
        Student student = new Student("javasummerschool", "java");

        FileOutputStream fos = new FileOutputStream("/tmp/serialUID.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(student);
    }
}
