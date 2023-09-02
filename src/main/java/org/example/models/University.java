// Module 27.8 intermediate project (Statistics: Student/University)
package org.example.models;

import com.google.gson.annotations.SerializedName;
import org.example.enums.StudyProfile;

import java.util.Objects;

public class University {
    @SerializedName("ID")
    private String id;
    @SerializedName("UnivFullName")
    private String fullName;
    @SerializedName("UnivShortName")
    private String shortName;
    @SerializedName("UnivYoF")
    private int yearOfFoundation;
    @SerializedName("UnivMAinProf")
    private StudyProfile mainProfile;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        return "University: {" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}' + '\n';
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return yearOfFoundation == that.yearOfFoundation && Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(shortName, that.shortName) && mainProfile == that.mainProfile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, yearOfFoundation, mainProfile);
    }
}
