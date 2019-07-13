package com.obss.method;

public class MethodParameter {

    int counter=0;

    static int staticCounter=0;
    public String getChangedNames(String param1, String param2) {
        param1 = param1 + param2 + " inside method";
        return param1;
    }

    public static void main(String[] args) {
        MethodParameter methodParameter = new MethodParameter();

        String param1 = "birinci";
        String param2 = "ikinci";
        String changedNames = methodParameter.getChangedNames(param1, param2);
        System.out.println(changedNames);
        System.out.println(param1);

        methodParameter.printParametersDotDotDot(2,3,4,1,2,3,4,5);
        methodParameter.printParametersWithArray(new int[]{2,3,4,5,6,6});
        methodParameter.printParametersWithStringAndVarArgs("obss", 1,2,3,4,5,6);

    }


    public static void soru() {
        int degisken = 25;
    }

    public void printParametersDotDotDot(int... parameters) {

        System.out.println(parameters[0]);

        for ( int element : parameters ) {
            System.out.println(element);
        }

        hesapla(3,5);

        hesapla(3.0,5.0);

    }

    public void printParametersWithStringAndVarArgs(String name, int... variables){
        int temp = 0;


        for (int sayac = 0; sayac < 5; sayac++) {

        }


    }

    public void printParametersWithArray(int[] parameters) {

    }

    public static void hesapla(int x, int y){

        System.out.println("output");

    }

    public static void hesapla(double x, double y){

    }

}
