package uz.b22.tasks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        File file = new File("files/numbers.txt");
        file.getParentFile().mkdirs();

        try (OutputStream out = new FileOutputStream(file, true)) {

            for (int i = 0; i < 10; i++) {
                int number = new Random().nextInt(101);
                out.write((number+"\n").getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
