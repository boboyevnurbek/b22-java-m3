package com.company.files;

import com.company.db.Database;
import com.company.entity.Customer;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public interface WorkWithFiles {

    Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    String BASE_FOLDER = "src/main/resources/documents";
    File CUSTOMER_FILE = new File(BASE_FOLDER, "customers.json");

    static void readCustomerList(){
        if(!CUSTOMER_FILE.exists()) return;

        try {
            List customers = GSON.fromJson(new BufferedReader(new FileReader(CUSTOMER_FILE)),
                    new TypeToken<List<Customer>>() {
                    }.getType());
            Database.customerList.clear();
            Database.customerList.addAll(customers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void writeCustomerList(){
        try (PrintWriter writer = new PrintWriter(CUSTOMER_FILE)) {
            writer.write(GSON.toJson(Database.customerList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static File generateCustomerExcelFile() {

        File file = new File(BASE_FOLDER, "customers.xlsx");

        try (FileOutputStream out = new FileOutputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook();
        ) {

            XSSFSheet sheet = workbook.createSheet();

            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("Chat id");
            header.createCell(1).setCellValue("First name");
            header.createCell(2).setCellValue("Last name");
            header.createCell(3).setCellValue("Phone number");

            int i=0;
            for (Customer customer : Database.customerList) {
                i++;
                XSSFRow row = sheet.createRow(i);
                row.createCell(0).setCellValue(customer.getChatId());
                row.createCell(1).setCellValue(customer.getFirstName());
                row.createCell(2).setCellValue(customer.getLastName());
                row.createCell(3).setCellValue(customer.getPhoneNumber());
            }

            for (int j = 0; j < 4; j++) {
                sheet.autoSizeColumn(j);
            }

            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    static File generateCustomerPdfFile() {
        File file = new File(BASE_FOLDER, "customers.pdf");

        try(PdfWriter pdfWriter = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument)) {

            pdfDocument.addNewPage();

            Paragraph paragraph = new Paragraph("Users");
            document.add(paragraph);

            float[] columns = {25f, 50f, 50f, 50f};
            Table table = new Table(columns);

            String[] header = {"Chat Id", "First Name", "Last Name", "Phone Number"};
            for (String s : header) {
                table.addCell(s);
            }

            for (Customer customer : Database.customerList) {
                table.addCell(customer.getChatId());
                table.addCell(customer.getFirstName());
                table.addCell(customer.getLastName()!=null ? customer.getLastName() : "");
                table.addCell(customer.getPhoneNumber());
            }

            document.add(table);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
