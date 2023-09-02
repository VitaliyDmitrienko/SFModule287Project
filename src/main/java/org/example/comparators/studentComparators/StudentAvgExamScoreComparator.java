// Module 26.9 intermediate project (Student/University method's comparator)
package org.example.comparators.studentComparators;

import org.example.models.Student;

public class StudentAvgExamScoreComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {

//      change default pattern method's arguments (o1,o2) to (o2,o1) for reverse compare order
//      from ascending to descending
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
