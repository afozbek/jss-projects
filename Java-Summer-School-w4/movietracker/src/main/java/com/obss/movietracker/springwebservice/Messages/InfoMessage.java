package com.obss.movietracker.springwebservice.Messages;

public class InfoMessage {
    private String message;

    public InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
