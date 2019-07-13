package com.obss.inner_class;

public class AnonymousClassExample {

    public static void main(String[] args) {
        Comparable comparable = new Comparable<Araba>() {
            @Override
            public int compareTo(Araba o) {
                return 0;
            }
        };
    }
}
