package com.obss.generics.box;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> t;

    public List<T> get() {
        return t;
    }

    public void set(List<T> t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();

        List<Integer> integerValues = new ArrayList<>();
        integerValues.add(23);
        integerValues.add(18);
        integerValues.add(11);

        box.set(integerValues);

        Box<String> stringBox = new Box<>();

        List<String> stringList = new ArrayList<>();
        
        stringList.add("obss");
        stringList.add("turkcell");
        stringList.add("vodafone");

        stringBox.set(stringList);


    }
}
