package com.assigment1.classes;

public class Class3 {
    public void callMethod() {
        try {
            Class2.willCallExceptionMethod();
        } catch (CustomException ex) {
            ex.writeErrorLogs(ex);
        }
    }
}
