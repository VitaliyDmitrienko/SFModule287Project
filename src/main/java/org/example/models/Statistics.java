// Module 27.8 intermediate project (Statistics: Student/University)
package org.example.models;

import org.example.enums.StudyProfile;


public class Statistics {

    private StudyProfile studyProfile;
    private double avgExamScore;
    private int quantityProfileStudents;
    private int quantityProfileUniversity;
    private String universityListStat;
//    private Set<String> universityListStat;
//    private float tmpSumAvgExamScore;

    public Statistics() {}


//    old version
//    public Statistics (StudyProfile studyProfile, float avgExamScore,
//                       int quantityProfileStudents,
//                       int quantityProfileUniversity, String universityListStat) {
////                       int quantityProfileUniversity, Set<String> universityListStat) {
//        this.studyProfile = studyProfile;
//        this.avgExamScore = (avgExamScore);
//        this.quantityProfileStudents = (quantityProfileStudents);
//        this.quantityProfileUniversity = (quantityProfileUniversity);
//        this.universityListStat = universityListStat;
//    }


    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double setAvgExamScore) {
        this.avgExamScore = setAvgExamScore;
    }

//    public void updateAvgExamScore(float addAvgExamScore) {
//        tmpSumAvgExamScore += addAvgExamScore;
//        float tmpAvgExamScore = tmpSumAvgExamScore / getQuantityProfileStudents();
//        setAvgExamScore(tmpAvgExamScore);
//    }

    public int getQuantityProfileStudents() {
        return quantityProfileStudents;
    }

    public void setQuantityProfileStudents(int quantityProfileStudents) {
        this.quantityProfileStudents = (quantityProfileStudents);
//        this.quantityProfileStudents = OptionalInt.of(quantityProfileStudents);
    }
//    public void addQuantityProfileStudents(int addQuantityProfileStudents) {
//        this.quantityProfileStudents += addQuantityProfileStudents;
//    }

    public int getQuantityProfileUniversity() {
        return quantityProfileUniversity;
    }

    public void setQuantityProfileUniversity(int quantityProfileUniversity) {
        this.quantityProfileUniversity = (quantityProfileUniversity);
//        this.quantityProfileUniversity = OptionalInt.of(quantityProfileUniversity);
    }
//    public void addQuantityProfileUniversity(int addQuantityProfileUniversity) {
//        this.quantityProfileUniversity += addQuantityProfileUniversity;
//    }
//    public void updateQuantityProfileUniversity() {
//        this.quantityProfileUniversity = (this.universityListStat.size());
//    }

    public String getUniversityListStat() {
        return universityListStat;
    }
//      old version
//    public Set<String> getUniversityListStat() {
//        return universityListStat;
//    }

    public void setUniversityListStat(String universityListStat) {
        this.universityListStat = universityListStat;
    }
//    old version
//    public void setUniversityListStat(Set<String> universityListStat) {
//        this.universityListStat = universityListStat;
//    }
//    old version
//    public void updateUniversityListStat(String updateUniversityListStat) {
//        this.universityListStat.add(updateUniversityListStat);
//    }

    @Override
    public String toString() {
        return "Statistics: {" +
                "studyProfile = " + studyProfile +
                ", avgExamScore = " + avgExamScore +
                ", quantityProfileStudents = " + quantityProfileStudents +
                ", quantityProfileUniversity = " + quantityProfileUniversity +
                ", universityListStat = " + universityListStat + '\'' +
                '}' + "\n";
    }
}
