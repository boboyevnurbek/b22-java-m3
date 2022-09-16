package uz.b22.service;

import java.io.*;
import java.util.Scanner;

public class WriteExample2 {
    public static void main(String[] args) {

        File file = new File("files/fruits.txt");
        file.getParentFile().mkdirs();

        try (Writer out = new FileWriter(file, true)) {

            while (true) {
                System.out.print("Enter fruit name (0-quit): ");
                String text = new Scanner(System.in).nextLine();

                if(text.equals("0") || text.equals("quit")) break;

                out.write(text + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
