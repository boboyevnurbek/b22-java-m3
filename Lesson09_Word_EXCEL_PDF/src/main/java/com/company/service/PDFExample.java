package com.company.service;

import com.company.entity.Person;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PDFExample {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) {

        File file = new File(BASE_FOLDER, "people.pdf");
        file.getParentFile().mkdirs();

        try (PdfWriter pdfWriter = new PdfWriter(file);
             PdfDocument pdfDocument = new PdfDocument(pdfWriter);
             Document document = new Document(pdfDocument);
        ) {

            pdfDocument.addNewPage();

            Paragraph paragraph = new Paragraph("People");
            paragraph.setTextAlignment(TextAlignment.CENTER);

            document.add(paragraph);

            float[] columnWidths = {20f, 60f, 60f, 20f, 60f, 150f};
            Table table = new Table(columnWidths);

            String[] columns = {"Number", "First name", "Last name", "Age", "Region", "Image"};

            for (int i = 0; i < columns.length; i++) {
                table.addCell(columns[i]);
            }

            int number = 0;
            for (Person person : Database.getPeople()) {
                table.addCell(String.valueOf(++number));
                table.addCell(person.getFirstName());
                table.addCell(person.getLastName());
                table.addCell(String.valueOf(person.getAge()));
                table.addCell(person.getRegion());

//                table.addCell(person.getImageUrl());

                ImageData imageData = ImageDataFactory.create(person.getImageUrl());
                Image image = new Image(imageData);
                table.addCell(image.setAutoScale(true));
            }

            document.add(table);

        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
