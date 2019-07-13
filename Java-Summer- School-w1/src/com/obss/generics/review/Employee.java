package com.obss.generics.review;

import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.Executors;

public class Employee {


    public static <T extends Number> List<T> getEmployeeList() {


        //List<T> subEmployeeList = new ArrayList<>();

        Set<Object> x = new HashSet<>();
        x.add("seref");
        x.add("acet");
        
        for(Object object : x) {
            String s = String.valueOf(object);
        }
        
        
        //return subEmployeeList;

        return null;
    }

    public static void main(String[] args) {
        List<Integer> employeeList = Employee.getEmployeeList();

        List<Double> employeeList1 = Employee.getEmployeeList();


    }

    public static Number getNumber(){
        return new Integer(5);
    }


    private static class SubEmployee extends Employee {

    }
}
