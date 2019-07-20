package com.javasummerschool.array;

public class ArrayLoop {

    public static void main(String[] args) {

        String[] nameArray = new String[5];
        int length = nameArray.length;

        for (int i = 0; i < length - 1; i++) {
            nameArray[i] = i + ".th element";
        }

        nameArray[length - 1] = "Last element";

        for (String element : nameArray) {
            System.out.println("Your element : " + element);
        }

        float[] floatArray = new float[3];

        floatArray[0] = 3.3f;

        double[] doubleArray = new double[3];

        doubleArray[1] = 3d;

        String[] stringArray = new String[10];

        stringArray[0] = "string 1";


    }
}
