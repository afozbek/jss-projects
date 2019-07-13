package com.obss.staticusage;

public class StudentNotStatic {

    public int yas;
    public double notOrtalamasi;


    public StudentNotStatic(){
        yas=11;
        notOrtalamasi = 2.0;
    }

    public StudentNotStatic(int yas) {
        this.yas = yas;
    }

    public StudentNotStatic(double notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
    }

    public StudentNotStatic(int yas, double notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
        this.yas = yas;
    }

    public void method(){

        int deger = 0;
        System.out.println(yas);
    }
}
