package com.obss.enumeration;

public class EnumTest {

    public static void main(String[] args) {


        for (Day day : Day.values()) {
            System.out.println("Iteration :" + day);
        }

        Day monday1 = Day.valueOf("MONDAY");

        System.out.println("Output of valueOf" + monday1);
        System.out.println("The mood of the day : " + monday1.getMood());


    }

    public static void outputSth(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("This is monday switch");
                break;
            case TUESDAY:
                System.out.println("This is Tuesday switch");
                break;
            case WEDNESDAY:
                System.out.println("This is Wednesday switch");
                break;
            default:
                System.out.println("there is no selected day");
                break;
        }
    }
}
