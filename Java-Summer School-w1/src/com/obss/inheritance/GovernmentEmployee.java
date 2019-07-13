package com.obss.inheritance;

public class GovernmentEmployee extends Employee {


    public GovernmentEmployee() {
       // super();
        System.out.println("GOVERNMENT Employee Constructor");
    }
    public void exposeToGovernment() {
        Employee employee = new Employee(2.0);
    }

    public void childMethod() {
        //super.parentMethod();
        parentMethod();
    }

    @Override
    public void commonMethod() {
        super.commonMethod();
        System.out.println("This is a GOVERNMENT!");
    }


    public void governmentSpecialMethod() {
        System.out.println("Government special method");
    }

    public static void main(String[] args) {


        // this is an invalid statement.
        // GovernmentEmployee governmentEmployee = new Employee();

        // Polymorphism
        Employee employee = new GovernmentEmployee();

        GovernmentEmployee employee2 = (GovernmentEmployee) employee;
        employee.commonMethod();
        
        GovernmentEmployee governmentEmployee = new GovernmentEmployee();
        Employee governmentEmployee1 = governmentEmployee;


    }
}
