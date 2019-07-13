package com.obss.loops;

import java.util.Scanner;

public class WhileLoopTest {

    public static void main(String args[]) {
        int i = 1;
        while (i < 5) {
            System.out.println("Bu " + i + ". donus");
            i++;
        }

        int x = 1;
        while (true) {

            System.out.println(x + ". dönüşü");
            if (x == 3) {
                System.out.println("Bitti");
                break;
            }
            x++;
        }

        Scanner keyboard = new Scanner(System.in);

        String komut = null;

        do {
            System.out.println("Bir komut giriniz");
            komut = keyboard.nextLine();

            System.out.println("Komutunuz : " + komut);

        } while (!komut.equals("exit"));

        System.out.println("Bitti");
    }
}
