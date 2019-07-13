package com.obss.array;

import java.util.Arrays;

public class MultidimensionalArray {

    public static void main(String[] args) {
        String[][] multiArray = new String[3][2];

        multiArray[0][0] = "Türkiye";
        multiArray[0][1] = "Ankara";

        multiArray[1][0] = "ABD";
        multiArray[1][1] = "California";

        multiArray[2][0] = "İngiltere";
        multiArray[2][1] = "Londra";

        String[] firstCities = multiArray[0];
        String[] secondCities = multiArray[1];
        String[] thirdCities = multiArray[2];

        System.out.println(Arrays.toString(firstCities));
        System.out.println(Arrays.toString(secondCities));
        System.out.println(Arrays.toString(thirdCities));

    }
}
