package com.javasummerschool.enumeration;

public class PrivateConstructorTest {


    public static void main(String[] args) {
       // 
        // Private constructor can not be initialized
        // new PrivateConstructor();

        PrivateConstructor obj = PrivateConstructor.getObject();
        obj.sendMessage();
    }
}
