package com.obss.inputreader;


import java.util.Scanner;

public class InputReaderTest {


    public static void main(String args[]) {



    }


    public static void scan(){
        Scanner scanner = new Scanner(System.in);
        

        // TODO: Bu kod iterative yazildi recursion ile yazilabilir.
        System.out.println("Bir sayi giriniz : ");

        String firstValue = scanner.nextLine();

        System.out.println("Girdiğiniz sayi : " + firstValue);

        System.out.println("İkinci bir sayi giriniz");
        String secondValue = scanner.nextLine();

        System.out.println("Girdiğiniz ikinci sayi : " + secondValue);

        int firstInt = Integer.parseInt(firstValue);
        int secondInt = Integer.parseInt(secondValue);

        int sumOfValues = firstInt + secondInt;

        System.out.println("Girdiginiz sayilarin toplami : " + sumOfValues);

        int control = 5;
        int control2 = 5;
        if (control == control2 & sumOfValues == 10) {
            System.out.println("10 numara adamsın.");
        } else {
            System.out.println("Bir işe yaramazsın.");
        }

        System.out.println();

        if(checkClock() && checkLimit()){

        }

        boolean negativeCondition = false;

        System.out.println("Not Condition :" + !negativeCondition);
    }

    private static boolean checkLimit() {
        return true;
    }

    private static boolean checkClock() {
        return false;
    }


}
