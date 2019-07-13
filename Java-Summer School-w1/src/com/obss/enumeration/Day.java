package com.obss.enumeration;

public enum Day {

    MONDAY("too bad"),
    TUESDAY("not bad"),
    WEDNESDAY("so so"),
    THURSDAY("getting fine"),
    FRIDAY("great"),
    SATURDAY("i love this day"),
    SUNDAY("lazy day");

    private String mood;
    private int temperature;

    Day(String mood) {
        this.mood = mood;
    }

    private Day(String mood, int temperature) {
        this.mood = mood;
        this.temperature = temperature;
    }

    public String getMood() {
        return mood;
    }
}
