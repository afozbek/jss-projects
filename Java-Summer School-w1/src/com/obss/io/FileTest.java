package com.obss.io;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("/tmp/ioTest.txt");

        boolean newFile = false;
        try {
            newFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File created : " + newFile);
        boolean delete = file.delete();

        System.out.println("File is deleted successfully : " + delete);


        File denemeFile = new File("/tmp/deneme");

        System.out.println("Length of deneme file : " + denemeFile.length());
        System.out.println("File exists ? : " + denemeFile.exists());

        File directory = new File("/tmp/powerlog");

        System.out.println("/tmp/powerlog is a directory : " + directory.isDirectory());

        String[] list = directory.list();

        for(String element : list) {
            System.out.println("File in directory /tmp/powerlog : " + element);
        }

        File textFile = new File("/tmp/powerlog/textFile.txt");

        String[] list1 = textFile.list();

        // The following statement will throw a NullPointerException
//        System.out.println(list1.length);

        System.out.println("The last modified time of tex/tmp/powerlog/textFile.txt : " + new Date(textFile.lastModified()));


        File notExistingDirectory = new File("/tmp/powerlog/obssDirectory");

        if(!notExistingDirectory.exists()){
            notExistingDirectory.mkdir();
        }


    }
}
