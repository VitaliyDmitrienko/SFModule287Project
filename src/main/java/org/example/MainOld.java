// Module 26.9 intermediate project (ser/deser Student/University)
package org.example;


import org.example.models.Student;
import org.example.models.University;
import org.example.utils.JsonUtils;
import org.example.utils.XLSXFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class MainOld {

    public static void main(String[] args) throws IOException {

//        Utility  Class XLSXFileReader() has private constructor & forbidden to create instance
//        System.out.println(new XLSXFileReader());

//        Utility Class UnitedComparator() has private constructor & forbidden to create instance
//        System.out.println(new UnitedComparator());

//        Utility Class JsonUtils() has private constructor & forbidden to create instance
//        System.out.println(new JsonUtils());


        List<Student> studentDataStorage = new ArrayList<>(XLSXFileReader.getStudentData());
        List<University> universityDataStorage = new ArrayList<>(XLSXFileReader.getUniversityData());

        System.out.println("<======================= Student chapter (start) ============================>");
        Student studentSentToJson = studentDataStorage.get(0);
        System.out.println("Student (single/original) sent to Json: \n" + studentSentToJson);
        String studentReceivedFromJson = JsonUtils.studentToJson (studentSentToJson);
        System.out.println("Student (single) converted to Json-string: \n" + studentReceivedFromJson);
        System.out.println();

        Student studentRecoveredFromJson = JsonUtils.studentFromJson(studentReceivedFromJson);
        System.out.println("Student (single) received & recovered from Json: \n" + studentRecoveredFromJson);
        System.out.println();
        System.out.println("Students (single) sent to & received from Json are equals? This is: << "
                + studentSentToJson.equals(studentRecoveredFromJson) + " >>.");
        System.out.println();

        String studentListToJson = JsonUtils.studentListToJson (studentDataStorage);
        System.out.println("Full Student's List converted to Json format: ");
        System.out.println("Total List size is: " + studentDataStorage.size() + " .");
        System.out.println("Head of Full List Json-string. ");
        System.out.println(studentListToJson);
        System.out.println("End of Full List Json-string. ");
        System.out.println();

        List<Student> studentListFromJson = JsonUtils.studentListFromJson(studentListToJson);
        System.out.println("Full Students List received & recovered from Json format to original: ");
        System.out.println("Total List size is: " + studentListFromJson.size() + " .");
        System.out.println(studentListFromJson);
        System.out.println("studentDataStorage size is: " + studentDataStorage.size());
        System.out.println("studentListFromJson size is: " + studentListFromJson.size());
        System.out.println();
        System.out.println("Student's Lists size (sent & received) from Json are equals? This is: << "
                + (studentDataStorage.size() == studentListFromJson.size()) + " >>.");
        System.out.println();

        System.out.println("Students List In/Out from Json one after the other at the same time by double/concat to single Stream: \n");
        Stream<Student> studentList1 = studentDataStorage.stream();
        Stream<Student> studentList2 = studentDataStorage.stream();
        Stream.concat(
                        studentList1.limit(12).map(JsonUtils::studentToJson),
                        studentList2.limit(12).map(JsonUtils::studentToJson).
                                map(JsonUtils::studentFromJson))
                .forEach(System.out::println);
        System.out.println("<======================= Student chapter (end) ============================>");
        System.out.println();

        System.out.println("<======================= University chapter (start) ============================>");
        University universitySentToJson = universityDataStorage.get(5);
        System.out.println("University (original/single) sent to Json: \n" + universitySentToJson);
        System.out.println();
        String universityReceivedJson = JsonUtils.universityToJson (universitySentToJson);
        System.out.println("University (single) converted to Json-string: \n" + universityReceivedJson);
        System.out.println();

        University universityRecoveredFromJson = JsonUtils.universityFromJson(universityReceivedJson);
        System.out.println("University received & recovered from Json: \n" + universityRecoveredFromJson);
        System.out.println();
        System.out.println("University sent to & received from Json are equals? This is: <<"
                + studentSentToJson.equals(studentRecoveredFromJson) + ">>.");

        String universityListToJson = JsonUtils.universityListToJson (universityDataStorage);
        System.out.println("Full Universities List converted to Json format: ");
        System.out.println("Total List size is: " + universityDataStorage.size() + " .");
        System.out.println("Head of Full List Json-string. ");
        System.out.println(universityListToJson);
        System.out.println("End of Full List Json-string. ");
        System.out.println();

        List<University> universityListFromJson = JsonUtils.universityListFromJson(universityListToJson);
        System.out.println("Full University's List received & recovered from Json format to original: ");
        System.out.println("Total List size is: " + universityListFromJson.size() + " .");
        System.out.println(universityListFromJson);
        System.out.println("universityDataStorage size is: " + universityDataStorage.size());
        System.out.println("universityListFromJson size is: " + universityListFromJson.size());
        System.out.println();
        System.out.println("Universities Lists size (sent & received) from Json are equals? This is: << "
                + (universityDataStorage.size() == universityListFromJson.size()) + " >>.");
        System.out.println();

        System.out.println("Universities List In/Out from Json parallel at the same time by single Stream: \n");
        Stream<University> universityList1 = universityDataStorage.stream();
        Stream<University> universityList2 = universityDataStorage.stream();
        Stream.concat(
                        universityList1.limit(12).map(JsonUtils::universityToJson),
                        universityList2.limit(12).map(JsonUtils::universityToJson).
                                map(JsonUtils::universityFromJson))
                .forEach(System.out::println);
        System.out.println("<======================= University chapter (end) ============================>");
        System.out.println();

    }
}