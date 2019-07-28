package com.obss.movietracker.springwebservice.Service.Util;

public class PasswordWrongException extends Throwable {
    private String errorMessage;

    public PasswordWrongException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
