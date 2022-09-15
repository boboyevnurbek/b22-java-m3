package uz.b22.service;

import java.io.*;
import java.util.Objects;

public class App3_v2 {
    public static void main(String[] args) {


        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/uz/b22/service/App3.java"));) {

            String line = null;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("some");
        }
    }
}
