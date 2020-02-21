package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    public static String readData(String inputFilePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(inputFilePath)));
    }

    public static void printData(String outputFilePath, String data) {
        try (PrintWriter printWriter = new PrintWriter(new File(outputFilePath))) {
            printWriter.print(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
