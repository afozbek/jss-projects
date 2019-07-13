package com.obss.staticusage;

import java.util.Objects;

public class Student {

    public static int yas = 23;
    public static double notOrtalamasi = 2.0;
    public static void mezunOl(){

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {

    }
}
