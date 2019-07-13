package com.obss.initializer;

import com.mysql.cj.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InitializationTest {


    static {
        System.out.println("Static init block");
    }

    {
        System.out.println("init block");
    }

    public InitializationTest() {
        System.out.println("Default Constructur");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        File fdsfsdf = new File("fdsfsdf");

        Path x = Paths.get("/tmp/");

        new InitializationTest();
        new InitializationTest();
        new InitializationTest();
        new InitializationTest();
        
        Map<String, String> map = new HashMap<>();
        
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
        }
        
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println("Value with KeySet : " + value);
        }

        for(String value : map.values()) {
            System.out.println("Map Value : " + value);
        }

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

    }
}
