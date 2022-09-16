package uz.b22.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5_v2 {
    public static void main(String[] args) {

        // any.txt dagi barcha sonlarning yig'indisini aniqlash
        File file = new File("files/any.txt");
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {

            double total = 0;
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    total += scanner.nextDouble();
                    // System.out.println("scanner.nextDouble()() = " + scanner.nextDouble());
                }else if (scanner.hasNextInt()) {
                    System.out.println("scanner.nextInt() = " + scanner.nextInt());
                } else if (scanner.hasNextFloat()) {
                    System.out.println("scanner.nextFloat() = " + scanner.nextFloat());
                }
                //...
                else {
                    System.out.println("scanner.next() = " + scanner.next());
                }
            }

            System.out.println("total = " + total);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
