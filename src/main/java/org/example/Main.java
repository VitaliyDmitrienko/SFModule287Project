// Module 27.8 intermediate project (Statistics: Student/University)
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


public class Main {

    public static void main(String[] args) throws IOException {

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

        String outputFilePath = "src\\main\\resources\\StatisticsOutput.xlsx";


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
        System.out.println(finalStatistics);

        XLSXFileWriter.generateStatistics(finalStatistics, outputFilePath);



    }
}