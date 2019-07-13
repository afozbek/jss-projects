package com.obss.pojo;

public class Pojo {

    private int sayi;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public int getSayi() {

        return sayi;
    }

    public String getId() {
        return id;
    }

    public void setSayi(int sayi) {

        this.sayi = sayi;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "sayi=" + sayi +
                ", id='" + id + '\'' +
                '}';
    }

}
