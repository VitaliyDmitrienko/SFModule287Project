// Module 27.8 intermediate project (Statistics: Student/University)
package org.example.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.models.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XLSXFileWriter {
    private XLSXFileWriter () {
        System.out.println("Private constructor.");
        System.out.println("Forbidden to create this class instance.");
    }
    public static void generateStatistics(List<Statistics> statisticsList, String outputFilePath) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Statistics");
            for (int i = 0; i <= statisticsList.size(); i++) {
                sheet.setColumnWidth(i, 7000);
//                sheet.autoSizeColumn(i);
            }

            Row header = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.FINE_DOTS);

            XSSFFont font = workbook.createFont();
            font.setFontName("Calibri");
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            headerStyle.setFont(font);

            Cell headerCell = header.createCell(0);
            headerCell.setCellValue("Study Profile");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(1);
            headerCell.setCellValue("Average Examine Score");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(2);
            headerCell.setCellValue("Quantity Profile Students");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(3);
            headerCell.setCellValue("Quantity Profile University");
            headerCell.setCellStyle(headerStyle);

            headerCell = header.createCell(4);
            headerCell.setCellValue("University Profile List");
            headerCell.setCellStyle(headerStyle);

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            for (int i = 0; i < statisticsList.size(); i++) {
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(String.valueOf(statisticsList.get(i).getStudyProfile()));
                row.createCell(1).setCellValue(statisticsList.get(i).getAvgExamScore());
                row.createCell(2).setCellValue(statisticsList.get(i).getQuantityProfileStudents());
                row.createCell(3).setCellValue(statisticsList.get(i).getQuantityProfileUniversity());
                row.createCell(4).setCellValue(statisticsList.get(i).getUniversityListStat());


            }

//        Row row = sheet.createRow(2);
//        Cell cell = row.createCell(0);
//        cell.setCellValue("John Smith");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(1);
//        cell.setCellValue(20);
//        cell.setCellStyle(style);

//        File currDir = new File(".");
//        String path = currDir.getAbsolutePath();
//        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

//        FileOutputStream outputStream = new FileOutputStream(outputFilePath);
//        workbook.write(outputStream);
//        workbook.close();

            try (FileOutputStream out = new FileOutputStream(outputFilePath)) {
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Excel file: \"" + outputFilePath +  "\" successful created!");

    }
}
