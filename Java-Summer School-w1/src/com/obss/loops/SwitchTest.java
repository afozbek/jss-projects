package com.obss.loops;

public class SwitchTest {

    public static void main(String[] args) {


        int i = 5;

        String temp = "obss";

        switch (i) {
            case 1:
                System.out.println("Bir numarali adim");
                break;
            case 5:
                System.out.println("Beş Numaralı Adım");
                break;
            case 10:
                System.out.println("On numaralı Adım");
                break;
            default:
                System.out.println("Default adım");
                break;
        }

        switch (temp) {
            case "obss":
                System.out.println("Great company");
                break;
            case "turkcell":
                System.out.println("Great communication");
                break;
            default:
                System.out.println("Default company");
                break;
        }
    }
}
