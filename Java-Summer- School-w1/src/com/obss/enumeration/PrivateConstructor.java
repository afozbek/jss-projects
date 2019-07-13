package com.obss.enumeration;

public class PrivateConstructor {

    private static final PrivateConstructor object = new PrivateConstructor();

    private PrivateConstructor() {

    }

     public void sendMessage(){
        System.out.println("Hello World");
    }


    public static PrivateConstructor getObject() {
        return object;
    }
}
