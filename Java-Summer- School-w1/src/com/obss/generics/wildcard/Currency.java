package com.obss.generics.wildcard;

public interface Currency {
    void addMoney();

    default void defaultMethod() {
        System.out.println("This is a Java 9 feature!");
    }
}
