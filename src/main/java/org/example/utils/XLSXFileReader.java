// Module 26.9 intermediate project (Student/University method's comparator)
package org.example.utils;


import org.example.builders.StudentBuilder;
import org.example.builders.UniversityBuilder;
import org.example.models.Student;
import org.example.models.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


public final class XLSXFileReader {

    private XLSXFileReader () {
        System.out.println("Private constructor.");
        System.out.println("Forbidden to create this class instance.");
    }

    public static ArrayList<Student> getStudentData() throws IOException {

        ArrayList<Student> studentDataStorageExtractor = new ArrayList<>();
        FileInputStream fileXLSX = null;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Iterator<Row> iterator = null;
        try {

            //read file "universityInfo.xlsx" from directory: \root\src\main\resources\
            String fileName = "src\\main\\resources\\universityInfo.xlsx";
            fileXLSX = new FileInputStream(fileName);

            // получаем экземпляр XSSFWorkbook для обработки xlsx файла
            workbook = new XSSFWorkbook(fileXLSX);

            // выбираем первый лист для обработки
            // нумерация начинается из 0
            sheet = workbook.getSheet("Студенты");

            // получаем Iterator по всем строкам в листе
            iterator = sheet.rowIterator();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // пропускаем заголовок таблицы 0-строку
        assert iterator != null;
        iterator.next();

        while (iterator.hasNext()) {
            Row cells = iterator.next();
            if (cells.getCell(0) == null) {
                break;
            }

//            Version #1: add new Student to List by abstract class
//            studentDataStorageExtractor.add(new Student(
//                    cells.getCell(1).getStringCellValue(),
//                    cells.getCell(0).getStringCellValue(),
//                    (int) cells.getCell(2).getNumericCellValue(),
//                    (float) cells.getCell(3).getNumericCellValue()));

//            Version #2: add new Student to List by pattern "StudentBuilder" (class creator)
            studentDataStorageExtractor.add(new StudentBuilder().setFullName(cells.getCell(1).getStringCellValue()).
                    setUniversityId(cells.getCell(0).getStringCellValue()).
                    setCurrentCourseNumber((int) cells.getCell(2).getNumericCellValue()).
                    setAvgExamScore((float) cells.getCell(3).getNumericCellValue()).
                    createStudent());

        }

        try {
            fileXLSX.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentDataStorageExtractor;
    }



    public static ArrayList<University> getUniversityData () throws IOException {

        ArrayList<University> universityDataStorageExtractor = new ArrayList<>();
        FileInputStream fileXLSX = null;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        Iterator<Row> iterator = null;

        try {

            //read file "universityInfo.xlsx" from directory: \root\src\main\resources\
            String fileName = "src\\main\\resources\\universityInfo.xlsx";
            fileXLSX = new FileInputStream(fileName);

            // получаем экземпляр XSSFWorkbook для обработки xlsx файла
            workbook = new XSSFWorkbook(fileXLSX);

            // выбираем первый лист для обработки
            // нумерация начинается из 0
            sheet = workbook.getSheet("Университеты");

            // получаем Iterator по всем строкам в листе
            iterator = sheet.rowIterator();



        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }

//        пропускаем заголовок таблицы (0-строку)
        assert iterator != null;
        iterator.next();

        while (iterator.hasNext()) {
            Row cells = iterator.next();
            if (cells.getCell(0) == null) {
                break;
            }

//            Version #1: add new University to List by abstract class
//            universityDataStorageExtractor.add(new University(
//                    cells.getCell(0).getStringCellValue(),
//                    cells.getCell(1).getStringCellValue(),
//                    cells.getCell(2).getStringCellValue(),
//                    (int) cells.getCell(3).getNumericCellValue(),
//                    StudyProfile.valueOf(cells.getCell(4).getStringCellValue())));

//            Version #2: add new University to List by pattern "UniversityBuilder" (class creator)
            universityDataStorageExtractor.add(new UniversityBuilder().
                    setFullName(cells.getCell(1).getStringCellValue()).
                    setId(cells.getCell(0).getStringCellValue()).
                    setShortName(cells.getCell(2).getStringCellValue()).
                    setYearOfFoundation((int) cells.getCell(3).getNumericCellValue()).
                    setMainProfile(StudyProfile.valueOf(cells.getCell(4).getStringCellValue())).
                    createUniversity());

        }

        try {
            fileXLSX.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return universityDataStorageExtractor;

    }

}
