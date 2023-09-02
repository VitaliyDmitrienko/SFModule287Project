// old version - change realisation to new Class: StatisticsUtil (via Stream).
package org.example.utils;

//import org.example.enums.StudyProfile;
//import org.example.models.Statistics;
//import org.example.models.Student;
//import org.example.models.University;
//
//import java.util.*;

//public class StatisticsGeneratorOld {
//    private StatisticsGenerator () {
//        System.out.println("Private constructor.");
//        System.out.println("Forbidden to create this class instance.");
//    }
//
//    public static List<Statistics> statisticsCreator (List<Student> inputStudentList,
//                                                      List<University> inputUniversityList) {
//
//        Set<StudyProfile> studyProfileStats = new HashSet<>();
//        Set<Statistics> outputStatistics = new LinkedHashSet<>();
//
//        for (University university: inputUniversityList) {
//            studyProfileStats.add(university.getMainProfile());
//        }
//
//        for (StudyProfile studyProfile: studyProfileStats) {
//            Statistics currentStatistics = new Statistics(studyProfile,
//                    0, 0, 0, "");
////                    0, 0, 0, new HashSet<>());
//            for (University university : inputUniversityList) {
//                for (Student student : inputStudentList) {
//                    if (university.getMainProfile().equals(studyProfile)) {
//                        if (university.getId().equals(student.getUniversityId())) {
//                            currentStatistics.addQuantityProfileStudents((1));
////                            currentStatistics.addQuantityProfileStudents(OptionalDouble.of(1.0));
//                            currentStatistics.updateAvgExamScore((student.getAvgExamScore()));
////                            currentStatistics.updateAvgExamScore(OptionalDouble.of(student.getAvgExamScore()));
//                            currentStatistics.updateQuantityProfileUniversity();
//                            currentStatistics.updateUniversityListStat(university.getShortName());
//                            outputStatistics.add(currentStatistics);
//                        }
//                    }
//                }
//            }
//            outputStatistics.add(currentStatistics);
//
//        }
//        List<Statistics> finalStatistics = new ArrayList<>(outputStatistics);
//
//        return finalStatistics;
//    }
//
//}

//    OptionalDouble avrExamScoreByProfile = studentListByProfile.stream()
//            .mapToDouble(Student::getAvgExamScore)
//            .average();
//avrExamScoreByProfile.ifPresent(value -> statistics.setAvrExamScore(
//        BigDecimal.valueOf(value).setScale(3, RoundingMode.HALF_UP).doubleValue()));
