package com.javasummerschool.jdbc;

public class ClassForNameTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class className = Class.forName("com.javasummerschool.jdbc.ClassForNameTest");
        System.out.println(className.getSimpleName());

        // Output: ClassForNameTest
    }
}
