package com.company.service;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class CalculateExpression {
    static final String BASE_FOLDER = "src/main/resources/files/documents";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter formula: ");
        String formula = scanner.nextLine();

        File file = new File(BASE_FOLDER, "calculate.xlsx");
        file.getParentFile().mkdirs();

        FileOutputStream out = new FileOutputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Calculator");

        XSSFRow header = sheet.createRow(0);

        XSSFCell cell = header.createCell(0);
        cell.setCellFormula(formula);

        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        evaluator.evaluateFormulaCell(cell);

        double result = cell.getNumericCellValue();

        workbook.write(out);

        workbook.close();
        out.close();

        System.out.println("result = " + result);
        file.delete();
    }
}
