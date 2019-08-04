package com.obss.movietracker.springwebservice.Exceptions;

public class PasswordWrongException extends Throwable {
    private static final long serialVersionUID = 121313131313L;

    public PasswordWrongException(String errorMessage) {
        super(errorMessage);
    }

    public PasswordWrongException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
