package com.obss.constants;

public class JavaConstants {

    private final String sinifCalismasi;
    private final String sinifAdi = "deneme";

    private static final String SIRKET_UNVANI = "LTD.STI";

    public JavaConstants(String parameter)
    {
        sinifCalismasi = parameter;
    }

    public void printOut() {
        System.out.println(SIRKET_UNVANI);

        calculate((int) 1.0, (int) 2.0);

        short p1 = 23;
        short p2 = 24;

        calculate(p1, p2);
        int i = (int) 4.9;

        calculate(1.0f, 2.0f);

        parameterCheck(2l);

    }


    public float calculate(int p1, int p2) {
        return p1 + p2;
    }

    public float calculate(float f1, float f2){
        System.out.println("This is the intented method");
        return f1 + f2;
    }

    public float calculate(double f1, double f2) {
        System.out.println("This is not the intended method.");
        return  ( float )f1 + (float) f2;
    }



    public void parameterCheck(long i) {
        System.out.println(i);
    }

    public void parameterCheck(int i) {
        System.out.println(i);
    }
}
