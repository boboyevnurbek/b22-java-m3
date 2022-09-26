package com.company.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchTask {
    static Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter something for search: ");
        String str = scannerStr.nextLine();


        try {
            URL url = new URL("https://yandex.uz/search/?text=" +
                    str.replace(' ', '+') + "&lr=10335");

            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer sb = new StringBuffer();

            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            int index = -1;

            String start = "<span class=\"OrganicTitleContentSpan organic__title\" role=\"text\">";
            String end = "</span>";

            do {
                index = sb.indexOf(start, index + 1);
                if(index == -1) break;

                int endIndex = sb.indexOf(end, index);
                if(endIndex == -1) break;

                String result = sb.substring(index + start.length(), endIndex);
                System.out.println(result.replaceAll("</?b>", ""));

            } while (index != -1);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
