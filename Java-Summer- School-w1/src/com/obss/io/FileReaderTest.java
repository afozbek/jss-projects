package com.obss.io;

import java.io.*;

public class FileReaderTest {

    public static void main(String[] args) throws IOException {

        // It reads the characters char by char. POOR PERFORMANCE!!
        // Old style of try-with-resources.
        FileReader reader = null;
        try {
            reader = new FileReader("/tmp/powerlog/textFile.txt");
            int data = -1;
            do {
                data = reader.read();
                System.out.print((char) data);
            } while(data != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }


        try(FileReader fileReader = new FileReader("/tmp/powerlog/textFile.txt")) {
            // It reads the characters line by line. Better Performance than FileReader!
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (Exception e) {

        }


        try(FileWriter fw = new FileWriter("/tmp/fileWriterTest.txt")) {
            fw.write("This line is added by Java application!\n");
        }



    }
}
