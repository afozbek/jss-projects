package com.obss.exception.hr.exception;

public class HrException extends RuntimeException {

    public HrException() {
    }

    public HrException(String message) {
        super(message);
    }

    public HrException(String message, Throwable cause) {
        super(message, cause);
    }

    public HrException(Throwable cause) {
        super(cause);
    }
}
