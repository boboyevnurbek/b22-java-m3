package com.company.service;

import com.company.entity.Comment;
import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App6 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/comments?postId=77");

            URLConnection urlConnection = url.openConnection();

            File file = new File("src/main/resources/posts.xlsx");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
                 XSSFWorkbook workbook = new XSSFWorkbook();
                 FileOutputStream out = new FileOutputStream(file)
            ) {
                Comment[] comments = new Gson().fromJson(reader, Comment[].class);

                if (comments.length == 0) {
                    System.out.println("\"no comments\" = " + "no comments");
                    return;
                }

                XSSFSheet sheet = workbook.createSheet("sheet");

                String[] columns = {"post id", "id", "name", "email", "body"};

                XSSFRow header = sheet.createRow(0);
                for (int i = 0; i < columns.length; i++) {
                    header.createCell(i).setCellValue(columns[i]);
                }

                CellStyle cs = workbook.createCellStyle();
                cs.setWrapText(true);   //Wrapping text

                int number = 0;
                for (Comment comment : comments) {
                    number++;
                    XSSFRow row = sheet.createRow(number);
                    row.createCell(0).setCellValue(comment.getPostId());
                    row.createCell(1).setCellValue(comment.getId());
                    row.createCell(2).setCellValue(comment.getName());
                    row.createCell(3).setCellValue(comment.getEmail());

                    XSSFCell cell = row.createCell(4);
                    cell.setCellValue(comment.getBody());
                    cell.setCellStyle(cs);
                }

                for (int i = 0; i < columns.length; i++) {
                    sheet.autoSizeColumn(i);
                }

                workbook.write(out);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
