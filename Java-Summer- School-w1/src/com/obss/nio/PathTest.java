package com.obss.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {



        Path directory = Paths.get("/tmp/nio");
        Path file = Paths.get("/tmp/nio/nioTest.txt");

        try {
            Files.createDirectory(directory);
            //file.getParent().toFile().getParentFile().mkdirs();
            Files.createFile(file);

            BufferedWriter bufferedWriter = Files.newBufferedWriter(file);

            bufferedWriter.write("This is a text written by New IO Package in Java");
            bufferedWriter.flush();
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
