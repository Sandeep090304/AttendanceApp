package com.example.attendanceapp.Adapter;

public class AttendanceModel {
    private String slNo;
    private String studentName;
    private String regNo;
    private boolean isPresent; // Added boolean field to track attendance

    public AttendanceModel(String slNo, String studentName, String regNo) {
        this.slNo = slNo;
        this.studentName = studentName;
        this.regNo = regNo;
        this.isPresent = false; // Default to absent
    }

    public String getSlNo() {
        return slNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRegNo() {
        return regNo;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
