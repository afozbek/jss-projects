package com.assigment1.classes;

public class Class2 {

    public static void willCallExceptionMethod() throws CustomException {
        Class1.willGenerateException();
    }
}
