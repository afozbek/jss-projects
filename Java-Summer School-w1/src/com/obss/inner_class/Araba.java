package com.obss.inner_class;

public class Araba {
    private double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public class Fren {

        private long measure;
        public long getMeasure() {
            // Inner class can reach the private variables of outer class
            System.out.println(price);
            return measure;
        }

        public void setMeasure(long measure) {
            this.measure = measure;
        }

    }


}
