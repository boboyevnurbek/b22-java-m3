package uz.b22.tasks;

import java.io.File;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);

        System.out.print("Enter folder name: ");
        String folderName = scannerStr.nextLine();

//        File folder = new File(folderName);
//        folder.mkdirs();

        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            File innerFolder = new File(folderName, dayOfWeek.name());
            innerFolder.mkdirs();
        }


    }
}
