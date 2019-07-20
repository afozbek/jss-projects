package com.javasummerschool.generics;


public final class CounterUtils {

  //  private CounterUtils() {

    // }

    public <N> N incrementCounter(N n){
        //System.out.println("T class is " + sayac.getClass());
        return n;
    }

    public static void main(String[] args) {
        CounterUtils counterUtils = new CounterUtils();
        Integer integer = counterUtils.<Integer>incrementCounter(3);

        String s = counterUtils.incrementCounter("s");
    }
}
