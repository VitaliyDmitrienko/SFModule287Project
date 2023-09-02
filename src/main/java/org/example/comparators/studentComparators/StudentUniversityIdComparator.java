// Module 26.9 intermediate project (Student/University method's comparator)
package org.example.comparators.studentComparators;

import org.apache.commons.lang3.StringUtils;
import org.example.models.Student;

public class StudentUniversityIdComparator implements IStudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(),o2.getUniversityId());
    }
}