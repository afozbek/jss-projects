package com.obss.loops;

import java.util.ArrayList;

public class BreakTest {

    public static void main(String[] args) {


        int y = 3;
        for (int i = 0; i < 10; i++) {

            if (i == 2) {
                continue;
            }

            System.out.println("Dongu donuyor: " + i);
            if (i == 3) {
                System.out.println("Uc'e geldi artık dur.");
                break;
            }
        }

        System.out.println("Program bitti");
    }
}
