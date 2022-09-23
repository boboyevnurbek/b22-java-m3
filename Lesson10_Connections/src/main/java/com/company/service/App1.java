package com.company.service;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) {
        try ( XSSFWorkbook workbook = new XSSFWorkbook("src/main/resources/excel.xlsx");) {

            XSSFSheet sheet = workbook.getSheet("Sheet0");

            System.out.println("sheet.getFirstRowNum() = " + sheet.getFirstRowNum());
            System.out.println("sheet.getLastRowNum() = " + sheet.getLastRowNum());

            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);

                for (int g = row.getFirstCellNum(); g < row.getLastCellNum(); g++) {
                    System.out.printf("%-20s", row.getCell(g));
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
