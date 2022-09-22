package com.company.service;

import com.company.entity.Person;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelExample {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) {

        File file = new File(BASE_FOLDER, "people.xlsx");
        file.getParentFile().mkdirs();

        try (FileOutputStream out = new FileOutputStream(file)) {

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("people");

            XSSFRow header = sheet.createRow(0);

            String[] columns = {"Number", "First name", "Last name", "Age", "Region", "Image"};

            for (int i = 0; i < columns.length; i++) {
                header.createCell(i).setCellValue(columns[i]);
            }

            List<Person> people = Database.getPeople();

            for (int i = 0; i < people.size(); i++) {
                Person person = people.get(i);

                XSSFRow row = sheet.createRow(i+1);

                row.createCell(0).setCellValue(i+1);
                row.createCell(1).setCellValue(person.getFirstName());
                row.createCell(2).setCellValue(person.getLastName());
                row.createCell(3).setCellValue(person.getAge());
                row.createCell(4).setCellValue(person.getRegion());
                row.createCell(5).setCellValue(person.getImageUrl());

            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            int rowIndex = people.size()+2;
            XSSFRow row = sheet.createRow(rowIndex);
            row.createCell(2).setCellValue("Average: ");
            row.createCell(3).setCellFormula("AVERAGE(D2:D"+(people.size()+1)+")");

            workbook.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
