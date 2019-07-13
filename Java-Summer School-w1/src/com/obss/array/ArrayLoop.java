package com.obss.array;

public class ArrayLoop {

    public static void main(String[] args) {

        String[] nameArray = new String[5];

        for (int i = 0; i < nameArray.length; i++) {
            nameArray[i] = i + ".th element";
        }

        nameArray[nameArray.length - 1] = "Last element";

        for (String element : nameArray) {
            System.out.println("Eleman : " + element);
        }

        float[] floatArray = new float[3];

        floatArray[0] = 3.3f;

        double[] doubleArray = new double[3];

        doubleArray[1] = 3d;

        String stringArray[] = new String[10];

        stringArray[0] = "string 1";


    }
}
