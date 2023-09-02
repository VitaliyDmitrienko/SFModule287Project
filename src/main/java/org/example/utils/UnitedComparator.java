package org.example.utils;

import org.example.comparators.studentComparators.*;
import org.example.comparators.universityComparators.*;
import org.example.enums.EStudentMethodComparator;
import org.example.enums.EUniversityMethodComparator;

public final class UnitedComparator {
    private UnitedComparator() {
        System.out.println("Private constructor.");
        System.out.println("Forbidden to create this class instance.");
    }

    public static IStudentComparator getStudentComparator(EStudentMethodComparator currentStudentMethod) {
//        IStudentComparator studentComparator;


        switch (currentStudentMethod) {
            case STUDENT_FULL_NAME_COMPARATOR:
                return new StudentFullNameComparator();
//                studentComparator = StudentFullNameComparator::compare;
//                break;
            case STUDENT_UNIVERSITY_ID_COMPARATOR:
                return new StudentUniversityIdComparator();
//                studentComparator = StudentUniversityIdComparator::compare;
//                break;
            case STUDENT_CURRENT_COURSE_COMPARATOR:
                return new StudentCurrentCourseNumberComparator();
//                studentComparator = StudentCurrentCourseNumberComparator::compare;
//                break;
            case STUDENT_AVG_EXAM_SCORE_COMPARATOR:
                return new StudentAvgExamScoreComparator();
//                studentComparator = StudentAvgExamScoreComparator::compare;
//                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentStudentMethod);
        }

//        return studentComparator;
        

    }

    public static IUniversityComparator getUniversityComparator(EUniversityMethodComparator currentUniversityMethod) {
//        IUniversityComparator universityComparator;

        switch (currentUniversityMethod) {
            case UNIVERSITY_FULL_NAME_COMPARATOR:
                return new UniversityFullNameComparator();
//                universityComparator = UniversityFullNameComparator::compare;
//                break;
           case UNIVERSITY_SHORT_NAME_COMPARATOR:
                return new UniversityShortNameComparator();
//                universityComparator = UniversityShortNameComparator::compare;
//                break;
           case UNIVERSITY_ID_COMPARATOR:
                return new UniversityIdComparator();
//                universityComparator = UniversityIdComparator::compare;
//                break;
            case UNIVERSITY_YEAR_OF_FOUNDATION_COMPARATOR:
                return new UniversityYearOfFoundationComparator();
//                universityComparator = UniversityYearOfFoundationComparator::compare;
//                break;
            case UNIVERSITY_MAIN_PROFILE_COMPARATOR:
                return new UniversityMainProfileComparator();
//                universityComparator = UniversityMainProfileComparator::compare;
//                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentUniversityMethod);
        }

//        return universityComparator;
    }
}
