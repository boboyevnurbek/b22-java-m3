package com.company.service;

import com.company.entity.Photo;
import com.google.gson.Gson;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App8 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/photos");
            URLConnection urlConnection = url.openConnection();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()))) {

                Gson gson = new Gson();

                Photo[] photos = gson.fromJson(reader, Photo[].class);

                writeToWordFile(photos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToWordFile(Photo[] photos) {

        File file = new File("src/main/resources/photos.docx");

        try (XWPFDocument document = new XWPFDocument();
             FileOutputStream out = new FileOutputStream(file);) {

            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun headerRun = paragraph.createRun();
            headerRun.setText("Photos");
            headerRun.setBold(true);

            XWPFTable table = document.createTable();
            table.setWidth("100%");

            XWPFTableRow headerRow = table.getRow(0);

            XWPFTableCell cell00 = headerRow.getCell(0);
            cell00.setWidth("10%");
            cell00.setText("Album id");


            XWPFTableCell cell01 = headerRow.createCell();
            cell01.setWidth("10%");
            cell01.setText("Id");

            XWPFTableCell cell02 = headerRow.createCell();
            cell02.setWidth("30%");
            cell02.setText("Title");

            XWPFTableCell cell03 = headerRow.createCell();
            cell03.setWidth("50%");
            cell03.setText("Image");

            int counter = 0;
            for (Photo photo : photos) {

                counter++;

                XWPFTableRow row = table.createRow();
                row.getCell(0).setText(String.valueOf(photo.getAlbumId()));
                row.getCell(1).setText(String.valueOf(photo.getId()));
                row.getCell(2).setText(String.valueOf(photo.getTitle()));
                //row.getCell(3).setText(String.valueOf(photo.getThumbnailUrl()));

                XWPFTableCell imageCell = row.getCell(3);
                XWPFParagraph imgPar = imageCell.addParagraph();
                imgPar.createRun().addPicture(
//                        new URL(photo.getThumbnailUrl()).openConnection().getInputStream(),
                        new URL("https://yunusobodavtosavdo.uz/uploads/exterior/KK/KK/K_/1649743378-9.jpg").openConnection().getInputStream(),
                        XWPFDocument.PICTURE_TYPE_JPEG,
                        "some",
                        Units.toEMU(300), Units.toEMU(150)
                );

                if(counter >= 2) break;
            }

            document.write(out);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
