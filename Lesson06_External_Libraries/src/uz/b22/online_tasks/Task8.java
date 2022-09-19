package uz.b22.online_tasks;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        File file = new File("files", "oxford.txt");
        if (!file.exists()) return;

        Map<String, String> dict = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line = null;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    String[] parts = line.split("  ");
                    if (parts.length == 2) {
                        dict.put(parts[0], parts[1]);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        if(dict.isEmpty()) return;

        System.out.print("Enter something: ");
        String search = new Scanner(System.in).nextLine();

        for (String key : dict.keySet()) {
            if(key.toLowerCase().contains(search.toLowerCase())){
                System.out.println(key+ " : "+dict.get(key));
            }
        }

    }
}
