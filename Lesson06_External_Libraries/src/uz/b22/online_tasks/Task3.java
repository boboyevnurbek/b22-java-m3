package uz.b22.online_tasks;

import java.io.File;

public class Task3 {
    public static void main(String[] args) {
        File folder = new File("src");

        if(folder.exists() && folder.isDirectory()){
            showDirectory(folder, "");
        }
    }

    private static void showDirectory(File folder, String prefix) {
        for (File file : folder.listFiles()) {
            System.out.println(prefix+file.getName());
            if(file.isDirectory()){
                showDirectory(file, prefix+"  ");
            }
        }
    }
}
