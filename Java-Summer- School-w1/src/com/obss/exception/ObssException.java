package com.obss.exception;

public class ObssException extends RuntimeException{

    public ObssException(String message) {
        super(message);
        System.out.println("Write this error to DB. Error : " + message );
    }
}
