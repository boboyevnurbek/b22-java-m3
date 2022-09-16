package uz.b22.tasks;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {

        // any.txt dagi barcha sonlarning yig'indisini aniqlash
        File file = new File("files/any.txt");
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line = null;
            while ((line = reader.readLine()) != null) {

                Matcher matcher = Pattern.compile("\\w+").matcher(line);

                while (matcher.find()){
                    //System.out.println("matcher.start() = " + matcher.start());
                    //System.out.println("matcher.end() = " + matcher.end());
                    System.out.println("matcher.group() = " + matcher.group());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
