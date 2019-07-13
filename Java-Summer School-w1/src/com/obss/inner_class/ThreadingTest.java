package com.obss.inner_class;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new MyThread());
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hey! I'm calling by an anonymous class");
            }
        });

        //Lambda expression
        executorService.submit(() -> {
            System.out.println("Hey! I'm calling by an lambda method");
        });
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Hey. I'm calling by a static inner class");
        }
    }
}
