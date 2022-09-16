package uz.b22.service;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class App1 {
    public static void main(String[] args) throws URISyntaxException {
//        File, Directory=Folder

//        File file = new File("src/uz/b22/service/App1.java");
//        File file = new File("src/uz/b22/service", "App1.java");
        File file = new File(new File("src/uz/b22/service"), "App1.java");


//        File file = new File("src/uz/b22");
//        File file = new File("Procfile");
//        File file = new File(".gitignore");

        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());

        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.getParentFile() = " + file.getParentFile());
        System.out.println("file.length() = " + file.length());

        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

    }
}
