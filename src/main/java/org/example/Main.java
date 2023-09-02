// Module 287 intermediate project (Logging: Statistics: Student/University)
package org.example;


import org.example.comparators.studentComparators.IStudentComparator;
import org.example.comparators.universityComparators.IUniversityComparator;
import org.example.enums.EStudentMethodComparator;
import org.example.enums.EUniversityMethodComparator;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.FINE;
import static java.util.logging.Level.INFO;



public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        String outputFilePath = "src\\main\\resources\\StatisticsOutput.xlsx";
        String loggingConfigFilePath = "src\\main\\resources\\logging.properties";


        try {
            LogManager.getLogManager().readConfiguration(
//                    Main.class.getResourceAsStream(loggingConfigFilePath));
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");


//        Utility  Class XLSXFileReader() has private constructor & forbidden to create instance
//        System.out.println(new XLSXFileReader());

//        Utility Class UnitedComparator() has private constructor & forbidden to create instance
//        System.out.println(new UnitedComparator());

//        Utility Class JsonUtils() has private constructor & forbidden to create instance
//        System.out.println(new JsonUtils());

//        Utility Class XLSXFileWriter() has private constructor & forbidden to create instance
//        System.out.println(new XLSXFileWriter());

//        Utility Class StatisticsGeneratorNew() has private constructor & forbidden to create instance
//        System.out.println(new StatisticsGeneratorNew());


        List<Student> studentDataStorage = new ArrayList<>(XLSXFileReader.getStudentData());
        IStudentComparator studentComparator =
                UnitedComparator.getStudentComparator(EStudentMethodComparator.STUDENT_AVG_EXAM_SCORE_COMPARATOR);
        studentDataStorage.sort(studentComparator);

        List<University> universityDataStorage = new ArrayList<>(XLSXFileReader.getUniversityData());
        IUniversityComparator universityComparator =
                UnitedComparator.getUniversityComparator(EUniversityMethodComparator.UNIVERSITY_YEAR_OF_FOUNDATION_COMPARATOR);
        universityDataStorage.sort(universityComparator);

        List<Statistics> finalStatistics = StatisticsGeneratorNew.statisticsCreator(studentDataStorage, universityDataStorage);
//        List<Statistics> finalStatistics = StatisticsGeneratorOld.statisticsCreator(studentDataStorage, universityDataStorage);
//        System.out.println(finalStatistics);

        logger.log(Level.INFO, "Statistics output generated finished successfully: ", finalStatistics);

        XLSXFileWriter.generateStatistics(finalStatistics, outputFilePath);

//        System.out.println("check");

        logger.log(Level.FINE, "Application fine finished");
        logger.log(Level.INFO, "Application finished");
        logger.fine( "Application fine finished");



    }
}