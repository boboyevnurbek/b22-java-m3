package uz.b22.service;

import java.io.*;
import java.util.Scanner;

public class WriteExample1 {
    public static void main(String[] args) {

        File file = new File("files/b22.txt");
        file.getParentFile().mkdirs();

        try (OutputStream out = new FileOutputStream(file, true)) {

            System.out.print("Enter name: ");
            String text = new Scanner(System.in).nextLine();

            out.write(("\n"+text).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
