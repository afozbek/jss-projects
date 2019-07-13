package com.obss.inheritance;

public class DownCastingProblem {

    public static void main(String[] args) {
        //This is valid
        //because primitive type downcasting doesn't have any inheritance relationship.
        double d = 2.2;
        int i = (int) d;

        System.out.println("Bu bir soru cevabidir: " + i);



        Employee parentEmployee = new Employee();

        // This statement will throw ClassCastException in runtime
        GovernmentEmployee governmentEmployeeWithCast = (GovernmentEmployee) parentEmployee;

        System.out.println("Finished without any problem");

    }
}
