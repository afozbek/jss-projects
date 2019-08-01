package com.assigment1.classes;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CustomException extends Exception {
    private final Logger LOGGER = Logger.getLogger(CustomException.class);
    private final String configPath = System.getProperty("user.dir")
            + "\\first\\log4j.properties";

    public CustomException() {
        super();
    }

    public CustomException(Exception ex) {
        System.out.println("EXCEPTION OCCURRED IN CUSTOM EXCEPTION");
    }

    public void writeErrorLogs(Exception ex) {
        PropertyConfigurator.configure(configPath);

        StackTraceElement[] traceElements = ex.getStackTrace();
        LOGGER.info("SOME ERRORS HAPPENED");
        for (StackTraceElement stackTraceElement : traceElements) {
            LOGGER.error(stackTraceElement);
        }
        LOGGER.warn("PLEASE FIX ABOVE ERRORS");
    }
}



