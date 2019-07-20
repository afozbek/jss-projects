package com.javasummerschool.oop.serialization;

import java.io.Serializable;

class Simple{}

public class Teacher implements Serializable {

    public Teacher() {

    }

    public String  showClassName(Object o){
        return o.getClass().getName();
    }

    public static void main(String[] args){
        Teacher teacher = new Teacher();
             String name = teacher.showClassName(new Simple());
             System.out.println(name);

    }
}
