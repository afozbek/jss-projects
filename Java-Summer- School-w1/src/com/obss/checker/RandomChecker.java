package com.obss.checker;

import com.obss.inheritance.Employee;

import java.util.Random;
import java.util.Scanner;

public class RandomChecker extends Employee{

    public void deneme() {
        System.out.println(this.maas);
    }
    public static void main(String[] args) {

        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Piyango tahmini için bir sayi giriniz.");

        int userInput;

        for (int i = 0; i < 5; i++) {

            userInput = scanner.nextInt();

            if (userInput < randomNumber) {
                System.out.println("Kücük bir sayi girdiniz, tahmininizi yükseltiniz. Girdiğiniz sayi :  " + userInput);
            } else if (userInput > randomNumber) {
                System.out.println("Büyük bir sayi girdiniz, tahmininizi küçültün");
            } else {
                System.out.println("Sayiyi dogru tahmin ettiniz. Sayi : " + userInput);
            }
        }

        System.out.println("Sayimiz : " + randomNumber);
    }
}
