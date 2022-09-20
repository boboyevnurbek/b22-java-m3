package com.company.service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.UUID;

public class DontOpen2 {
    public static void main(String[] args) {


        Runnable runnable = () -> {
//            for (int i = 0; i < 10; i++) {
//                Path path1 = Paths.get("E:/FILMS/Multiklar/everest_720.mp4");
//                Path path2 = Path.of("src2/abc"+i+".mp4");
//                try {
//                    Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            DontOpen.main(args);
        };

        new Thread(runnable).start();

        System.out.println("MAIN FINISH");

    }
}
