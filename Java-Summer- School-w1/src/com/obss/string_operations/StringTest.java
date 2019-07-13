package com.obss.string_operations;

public class StringTest {

    public static void main(String[] args) {
        String x = "immutable_data_can_not_be_changed";
        String object = new String("deneme");
        String object2 = new String("deneme");

        x.replace("e", "f");

        String concat = "first lesson " + "second lesson";
        System.out.println(x);


        String temp = "obss_class";

        char c = temp.charAt(0);
        System.out.println("chatAt 0 value of \"obss_class\" text : " + c);

        String concatedString = temp.concat("_java");
        System.out.println("Concatenated value with _java : " + concatedString);

        String tempCase = "OBSS_CLASS";

        System.out.println("Equals result of OBSS_CLASS and obss_class " + temp.equals(tempCase));

        System.out.println("EqualsIgnoreCase Result of OBSS_CLASS and obss_class : " + temp.equalsIgnoreCase(tempCase));
        System.out.println("The value of upper case temp after equalsIgnoreCase: " + tempCase);



        System.out.println("Substring 0,4 index result : " + temp.substring(0,4));
        System.out.println("Substring 4 index result : " + temp.substring(5));


        String tempUnderscores = "obss_class_third_forth";
        String[] split = tempUnderscores.split("_");

        System.out.println("Split values of " + tempUnderscores);
        System.out.println("Split 1 : " + split[0]);
        System.out.println("Split 2 : " + split[1]);
        System.out.println("Split 3 : " + split[2]);
        System.out.println("Split 4 : " + split[3]);


        // String Equality Control

        String temp1 = new String("value1");
        String temp2 = new String("value1");

        String temp23 = new String("value2");

        String temp3 = "value2";
        String temp4 = "value2";

        System.out.println("Equals for new String and literal : " + temp1.equals(temp2));
        System.out.println("== for literal and literal : " + (temp1 == temp2));

        System.out.println("Equals for new String and literal : " + temp3.equals(temp4));
        System.out.println("== for literal and literal : " + (temp3 == temp4));

        System.out.println(temp23 == temp3);


    }
}
