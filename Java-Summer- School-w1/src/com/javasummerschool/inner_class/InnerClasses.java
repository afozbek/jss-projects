package com.javasummerschool.inner_class;

import com.javasummerschool.oop.Car;

interface Callable{}

public class InnerClasses {

    private static int deger = 0;

    public static void main(String[] args) {
        Comparable<Araba> comparable = new ConcreteComparable();
        Car car = new Car() {
            @Override
            public String toString() {
                System.out.println("??");
                return "My name is Car";
            }
        };
        System.out.println(car.toString());
    }


    public static class ConcreteComparable implements Comparable<Araba> {

        @Override
        public int compareTo(Araba o) {
            System.out.println(deger);
            return 0;
        }
    }

    public class NonStaticConcreteComparable implements Comparable<Araba> {

        @Override
        public int compareTo(Araba o) {

            return deger;
        }
    }

    public void innerClassInMethod() {

        String abc = "java";


        Runnable thread = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread class");
                System.out.println(abc);
            }
        };

        class AhmetThread implements Runnable{

            @Override
            public void run() {
            }
        }
        Runnable thread2 = () -> {
            System.out.println("deneme");
        };

    }

}
