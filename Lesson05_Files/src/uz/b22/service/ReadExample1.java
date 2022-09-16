package uz.b22.service;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ReadExample1 {
    public static void main(String[] args) {

        File file = new File("files/b22.txt");
        file.getParentFile().mkdirs();

        try(FileInputStream in = new FileInputStream(file)) {

//            int r = -1;
//            while ((r = in.read()) != -1){
//                System.out.print((char)r);
//            }

            byte[] bytes = in.readAllBytes();
            String content = new String(bytes);

            String[] lines = content.split("\n");

            System.out.println("lines = " + Arrays.toString(lines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
