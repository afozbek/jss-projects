package com.obss.casting;

public class TypeCasting {

    public static void main(String[] args) {


        int x = 5;
        int y = 6;

        long sum = x + y;
        System.out.println(sum);

        long a = 1000l;
        long b = 2000l;

        int c = (int) a + (int) b;

        double d1 = 1.1d;
        double d2 = 2.2d;



        float floatValue = (float) d1 + (float ) d2;



//TODO: Check Type casting with byte
        byte byteValue = 126 + 1;

        System.out.println(Byte.MAX_VALUE);
        byte b1 = 12;
        byte b2 = 23;

        byte bToplam = (byte) (b1 + b2);

      //  byte b3 = 127
        // &&/  byte b4 = 128;

    }
}
