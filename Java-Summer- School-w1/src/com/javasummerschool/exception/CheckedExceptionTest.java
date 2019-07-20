package com.javasummerschool.exception;

import java.io.IOException;

class MotherClasss {
    public void k() {
    }
}

public class CheckedExceptionTest {


    public static void main(String[] args) {

        CheckedExceptionTest obj = new CheckedExceptionTest();
        obj.p();
        System.out.println("normal flow...");
    }

    public static void throwCheckedException() throws CheckedException {
        throw new CheckedException();
    }

    public static void throwRuntimeException() {
        throw new UncheckedException();
    }

    public static void runScenario1() {
        try {
            exceptionUsage();
        } catch (CheckedException e) {
            throw new UncheckedException(e);
        }
    }

    public static void exceptionUsage() throws CheckedException {
        CheckedException checkedException = new CheckedException();
        try {
            throw checkedException;
        } catch (CheckedException ex) {
            System.out.println("Checked Exception triggered");

        } catch (Exception ex) {
            System.out.println("Exception triggered");
        }

        // Syntax for catching multiple exceptions
        try {
            throw new CheckedException();
        } catch (CheckedException | RuntimeException ex) {

        }


        // This is true
        boolean deger = false || true;
        // This is false
        boolean deger2 = false || false;

        // This is false
        boolean deger3 = true && false;

        // This is true
        boolean deger4 = true && true;
    }

    void m() throws IOException {
        String k;
        throw new IOException("device error");//checked exception
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handled");
        }
    }
}
