package com.obss.exception;

public class ExceptionThrowerTest {

    public static void main(String[] args) throws InterruptedException {
        try {
            ExceptionThrower.throwObssException(true);

            //business operations
            // this line code may throw exception
            // open the stream
            // write operations
            // flush
            // close
        } catch (ObssException ex) {
            System.out.println("*** ALERT *** OBSS EXCEPTION");

            throw new RuntimeException("runtime exception", ex);
        } catch (Exception ex) {
            System.out.println("*** ALERT *** UNIDENTIFIED EXCEPTION");
            ex.printStackTrace();
        } finally {
            System.out.println("*** FINALLY *** Do your housekeeping staff");
        }

        try {
            ExceptionThrower.divideByZero(3);
        } catch (Exception ex) {
            System.out.println("*** RUNTIME EXCEPTION *** BE CAUTIOUS!");
            ex.printStackTrace();
        } finally {
            System.out.println("*** FINALLY RUNTIME *** This is a finally block of runtime exception");
        }


        Thread.sleep(10000L);
    }
}
