package com.company.service;

import lombok.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        int r = 0;
        try ( XSSFWorkbook workbook = new XSSFWorkbook("src/main/resources/excel.xlsx");) {

            XSSFSheet sheet = workbook.getSheet("Sheet0");

            for (int i = r; i <= sheet.getLastRowNum(); i++) {
                r = i;
                XSSFRow row = sheet.getRow(i);

                String name = row.getCell(0).getStringCellValue();
                String surname = row.getCell(1).getStringCellValue();
                double balance = row.getCell(2).getNumericCellValue();

                Person person = new Person(name, surname, balance);
                people.add(person);

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("r = " + r);
        }

        people.forEach(System.out::println);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
class Person{
    private String name;
    private String surname;
    private double balance;
}