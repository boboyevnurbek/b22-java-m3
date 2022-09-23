package com.company.service;

import com.company.entity.Comment;
import com.company.entity.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class App7 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");

            URLConnection urlConnection = url.openConnection();

            // POST larni url connection orqali o'qish va PDF ga table shaklida yozish

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Post[] posts = gson.fromJson(bufferedReader, Post[].class);

            PdfWriter pdfWriter = new PdfWriter("src/main/resources/post.pdf");

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            pdfDocument.addNewPage();

            float[] columnWidth = {60f, 60f, 60f, 400f};

            Table table = new Table(columnWidth);

            String[] cols = {"UserId", "Id", "Title", "Body"};

            for (int i = 0; i < cols.length; i++) {
                table.addCell(cols[i]);
            }

            for (int i = 0; i < posts.length; i++) {
                table.addCell(String.valueOf(posts[i].getUserId()));
                table.addCell(String.valueOf(posts[i].getId()));
                table.addCell(posts[i].getTitle());
                table.addCell(posts[i].getBody());
            }

            document.add(table);

            document.close();
            pdfDocument.close();
            pdfWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
