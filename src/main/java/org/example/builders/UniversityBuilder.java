// Module 27.8 intermediate project (Statistics: Student/University)
package org.example.builders;

import org.example.enums.StudyProfile;
import org.example.models.University;

public class UniversityBuilder {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;

    public UniversityBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UniversityBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UniversityBuilder setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public UniversityBuilder setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public UniversityBuilder setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public University createUniversity() {
        return new University ( id, fullName, shortName, yearOfFoundation, mainProfile );
    }
}