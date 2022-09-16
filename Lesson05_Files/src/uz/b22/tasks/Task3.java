package uz.b22.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

        File file = new File("files/numbers.txt");
        file.getParentFile().mkdirs();

        try (FileInputStream in = new FileInputStream(file)) {

            byte[] bytes = in.readAllBytes();
            String content = new String(bytes);

            String[] lines = content.split("\n");

            System.out.println("lines = " + Arrays.toString(lines));

            int sum = 0;
            for (String s : lines) {
                sum += Integer.parseInt(s);
            }
            System.out.println("sum = " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
