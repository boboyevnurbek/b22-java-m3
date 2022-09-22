package com.company.service;

import com.company.entity.Person;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExcelExample2 {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) {

        File file = new File(BASE_FOLDER, "people.xlsx");
        file.getParentFile().mkdirs();

        try (FileOutputStream out = new FileOutputStream(file)) {

            XSSFWorkbook workbook = new XSSFWorkbook();

            List<Person> people = Database.getPeople();

            Map<String, List<Person>> regionMap = people.stream()
                    .collect(Collectors.groupingBy(Person::getRegion));

            for (String region : regionMap.keySet()) {

                XSSFSheet sheet = workbook.createSheet(region);

                XSSFRow header = sheet.createRow(0);

                String[] columns = {"Number", "First name", "Last name", "Age", "Region", "Image"};

                for (int i = 0; i < columns.length; i++) {
                    header.createCell(i).setCellValue(columns[i]);
                }

                for (int i = 0; i < regionMap.get(region).size(); i++) {
                    Person person = regionMap.get(region).get(i);

                    XSSFRow row = sheet.createRow(i + 1);

                    row.createCell(0).setCellValue(i + 1);
                    row.createCell(1).setCellValue(person.getFirstName());
                    row.createCell(2).setCellValue(person.getLastName());
                    row.createCell(3).setCellValue(person.getAge());
                    row.createCell(4).setCellValue(person.getRegion());
                    row.createCell(5).setCellValue(person.getImageUrl());

                }

                for (int i = 0; i < columns.length; i++) {
                    sheet.autoSizeColumn(i);
                }

            }

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
