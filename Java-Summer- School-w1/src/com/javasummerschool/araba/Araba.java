package com.javasummerschool.araba;

public class Araba implements Comparable<Araba> {

    private int hiz;
    private String marka;

    public int getHiz() {
        return hiz;
    }

    public String getMarka() {
        return marka;
    }

    public void setHiz(int hiz) {

        this.hiz = hiz;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("python");
        sb.append("java");
        System.out.println(sb.toString());

        StringBuffer stringBuffer = new StringBuffer();
        sb.append("random");
        sb.append("java");

        System.out.println(stringBuffer.toString());

    }

    @Override
    public int compareTo(Araba o) {
        if (this.hiz == o.getHiz() && this.marka.equals(o.getMarka())) {
            return 0;
        } else if (this.hiz > o.getHiz()) {
            return 1;
        } else {
            return -1;
        }
    }
}
