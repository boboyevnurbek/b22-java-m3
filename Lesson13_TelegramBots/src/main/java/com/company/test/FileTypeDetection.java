package com.company.test;

import org.glassfish.grizzly.http.util.MimeType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileTypeDetection {
    public static void main(String[] args) {

        File folder = new File("src/main/resources/documents");
        for (File file : folder.listFiles()) {
            try {
                System.out.println("file.getName() = " + file.getName());
                String type = Files.probeContentType(file.toPath());
                System.out.println("type = " + type);
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
