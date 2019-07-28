package com.obss.movietracker.springwebservice.Exceptions;

public class PasswordWrongException extends Throwable {
    public PasswordWrongException(String errorMessage) {
        super(errorMessage);
    }

    public PasswordWrongException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}

