package uz.b22.service;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ReadExample2 {
    public static void main(String[] args) {

        File file = new File("files/fruits.txt");
        file.getParentFile().mkdirs();

        try (Reader reader = new FileReader(file)) {

            char[] chars = new char[(int) file.length()];

            reader.read(chars);

            String content = String.valueOf(chars);
            String[] lines = content.split("\n");
            System.out.println("lines = " + Arrays.toString(lines));
            Arrays.sort(lines);
            System.out.println("lines = " + Arrays.toString(lines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
