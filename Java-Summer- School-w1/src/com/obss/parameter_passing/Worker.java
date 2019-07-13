package com.obss.parameter_passing;

import com.obss.pojo.Pojo;
import com.obss.staticusage.Student;

public class Worker {

    private int weeklyHours;
    private double salary;

    public Worker(int weeklyHours, double salary) {
        this.weeklyHours = weeklyHours;
        this.salary = salary;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void promoteWorker(Worker worker) {
        worker.setSalary(2000.0);
        worker.setWeeklyHours(30);
        worker = new Worker(0, 0.0);
        worker.setWeeklyHours(23);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "weeklyHours=" + weeklyHours +
                ", salary=" + salary +
                '}';
    }
}
