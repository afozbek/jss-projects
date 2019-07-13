package com.obss.inheritance;

public class InstanceOfTest {

    public static void main(String[] args) {
        Employee e = new GovernmentEmployee();

        if(e instanceof GovernmentEmployee) {
            System.out.println("That's a Government Employee");
        } else {
            System.out.println("That's not a Government Employee");
        }


        GovernmentEmployee g = (GovernmentEmployee) e;
        System.out.println(e.getClass());
    }
}
