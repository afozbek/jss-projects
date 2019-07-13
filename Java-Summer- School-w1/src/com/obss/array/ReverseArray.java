package com.obss.array;

import java.util.Arrays;
import java.util.Random;

public class ReverseArray {

    public static void main(String[] args) {


        int[] array = new int[10];
        Random random = new Random();

        for(int i = 0 ; i<array.length ; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(array));

        for(int i = array.length-1 ; i > -1 ; i--) {
            System.out.print(array[i] + ", ");
        }


    }
}
