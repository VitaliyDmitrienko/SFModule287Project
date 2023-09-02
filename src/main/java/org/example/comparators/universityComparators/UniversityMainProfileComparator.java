// Module 26.9 intermediate project (Student/University method's comparator)
package org.example.comparators.universityComparators;

import org.apache.commons.lang3.StringUtils;
import org.example.models.University;

public class UniversityMainProfileComparator implements IUniversityComparator {
    @Override
    public int compare(University o1, University o2) {

//        also can various comparator versions getMainProfile().name() / getMainProfile().getProfileName() / getMainProfile().toString()
        return StringUtils.compare(o1.getMainProfile().toString(),
                o2.getMainProfile().toString());
    }
}