package com.obss.array;

public class ArrayTest {

    public static void main(String[] args) {
        int[] myArray = new int[10];

        myArray[0] = 1;
        myArray[1] = 5;

        int[] secondArray = new int[]{1, 2, 3, 4};
        int[] thirdArray = {1, 2, 3, 4};


        System.out.println("Before manipulating: " + myArray[3]);
        manipulateArray(myArray);

        System.out.println("After manipulating : " + myArray[3]);

        int param = 3;

        System.out.println("Before integer manipulation in method: " + param);
        manipulate(param);
        System.out.println("After integer manipulation in method " + param);

        String test = "unchangable data";

        System.out.println("Before String manipulatioın " + test);

        manipulate(test);

        System.out.println("After String manipulation " + test);
    }

    public static void manipulateArray(int[] pArray) {
        pArray[0] = 23;
        pArray[3] = 45;
    }

    public static void manipulate(int parameter) {
        parameter = 35;
    }

    public static void manipulate(String parameter) {
        parameter = "obssStringTest";
    }
}