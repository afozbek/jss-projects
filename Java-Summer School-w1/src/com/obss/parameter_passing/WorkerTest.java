package com.obss.parameter_passing;

public class WorkerTest {

    public static void main(String[] args) {
        Worker worker = new Worker(40, 1000.0);

        System.out.println("Before : " + worker);
        Worker.promoteWorker(worker);

        System.out.println("After : " + worker);
        System.out.println(worker);



    }



}
