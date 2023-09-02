package org.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsGeneratorNew {


    private StatisticsGeneratorNew() {
    }

    public static List<Statistics> statisticsCreator(List<Student> studentsListInput,
                                                    List<University> universitiesListInput) {

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> studyProfiles = universitiesListInput.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        studyProfiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);

            List<String> profileUniversityIds = universitiesListInput.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setQuantityProfileUniversity(profileUniversityIds.size());
            statistics.setUniversityListStat(StringUtils.EMPTY);
            universitiesListInput.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityListStat(
                            statistics.getUniversityListStat() + fullNameUniversity + ";"));
            List<Student> profileStudents = studentsListInput.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setQuantityProfileStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
//                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });


        return statisticsList;
    }
}
