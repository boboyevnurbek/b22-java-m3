package uz.b22.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {

        // PrintWriter yordamida "files/cars.txt" file ga
        // 5 ta car modelini yozish

        // BufferedReader yordamida "files/cars.txt" dagi
        // eng arzon car modellarini topish

        File file = new File("files/cars.txt");

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            String s = in.readLine();
            String minModel = "";

            int min = Integer.MAX_VALUE;
            while (s != null) {
                Integer a = Integer.parseInt(s.substring(s.lastIndexOf(" ") + 1));
                if (min > a) {
                    min = a;
                    minModel = s;
                }else if(min == a){
                    minModel += "\n"+s;
                }
                s = in.readLine();
            }

            System.out.println(minModel);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
