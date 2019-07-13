package com.obss.inheritance;

public class CompanyEmployee extends Employee {

    public CompanyEmployee(double maas) {
        super(maas);
    }

    @Override
    public void commonMethod() {
        System.out.println("This is a Company");
    }
}
