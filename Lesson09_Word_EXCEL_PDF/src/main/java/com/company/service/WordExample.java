package com.company.service;

import com.company.entity.Person;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WordExample {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) {

        File file = new File(BASE_FOLDER, "people.docx");
        file.getParentFile().mkdirs();

        try (FileOutputStream out = new FileOutputStream(file);
             XWPFDocument document = new XWPFDocument();) {

            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            XWPFRun run = paragraph.createRun();
            run.setText("People");
            run.setBold(true);
            run.setFontSize(16);
            run.setFontFamily("Consolas");


            XWPFTable table = document.createTable();
            table.setWidth("100%");

            XWPFTableRow header = table.getRow(0);

            XWPFTableCell cell00 = header.getCell(0);
            cell00.setText("First name");
            cell00.setWidth("20%");

            String[] columns = {"First name", "Last name", "Age", "Region", "Image"};

            for (int i = 1; i < columns.length; i++) {
                XWPFTableCell cell = header.createCell();
                cell.setText(columns[i]);
                cell.setWidth("20%");
            }

            List<Person> people = Database.getPeople();

            for (Person person : people) {
                XWPFTableRow row = table.createRow();
                row.getCell(0).setText(person.getFirstName());
                row.getCell(1).setText(person.getLastName());
                row.getCell(2).setText(String.valueOf(person.getAge()));
                row.getCell(3).setText(String.valueOf(person.getRegion()));

                XWPFTableCell imageCell = row.getCell(4);
                XWPFParagraph imageParagraph = imageCell.addParagraph();
                imageParagraph.createRun().addPicture(
                        new FileInputStream(person.getImageUrl()), XWPFDocument.PICTURE_TYPE_JPEG,
                        person.getImageUrl(),
                        Units.pixelToEMU(100), Units.pixelToEMU(100)
                );
            }

            XWPFParagraph pTime = document.createParagraph();
            pTime.setAlignment(ParagraphAlignment.RIGHT);

            XWPFRun rTime = pTime.createRun();
            rTime.setText(LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
            )+" holatiga ko'ra");
            rTime.setBold(true);

            document.write(out);

        }catch (IOException | InvalidFormatException e){
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
