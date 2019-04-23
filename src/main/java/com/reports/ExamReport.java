package com.reports;

public class ExamReport {

    private String lastname;
    private String subjextName;
    private int grade;

    public ExamReport(String lastname, String subjextName, int grade) {
        this.lastname = lastname;
        this.subjextName = subjextName;
        this.grade = grade;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubjextName() {
        return subjextName;
    }

    public void setSubjextName(String subjextName) {
        this.subjextName = subjextName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ExamReport{" +
                "lastname='" + lastname + '\'' +
                ", subjextName='" + subjextName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
