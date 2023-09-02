// Module 26.9 intermediate project (Student/University method's comparator)
package org.example.comparators.universityComparators;

import org.apache.commons.lang3.StringUtils;
import org.example.models.University;

public class UniversityFullNameComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(),o2.getFullName());
    }
}
