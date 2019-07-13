package com.obss.exception;

import java.io.IOException;
import java.util.Date;

public class ExceptionThrower {

    public static void throwObssException(boolean isThrowException) {
        if (isThrowException) {
            try {
                throwInnerException();
            }catch(Exception ex) {
                throw new IllegalArgumentException("weird error", ex);
            }

        } else {
            System.out.println("There is no such problem. Have a nice day!");
        }
    }

    private static void throwInnerException() {
        ObssException obssException = new ObssException("Exception is occured! Time: " + (new Date()));
        throw obssException;
    }


    public static int divideByZero(int number){
        return number/0;
    }
}
