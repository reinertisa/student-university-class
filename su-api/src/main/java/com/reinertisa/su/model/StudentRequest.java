package com.reinertisa.su.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;


public class StudentRequest {

    @NotBlank(message = "This field is required.")
    private String studentName;

    @NotBlank(message = "This field is required.")
    private String studentId;

    @Email(message = "Please enter a valid email.")
    private String studentEmail;

    private Set<UniversityClassRequest> universityClassesRequest;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Set<UniversityClassRequest> getUniversityClassesRequest() {
        return universityClassesRequest;
    }

    public void setUniversityClassesRequest(Set<UniversityClassRequest> universityClassesRequest) {
        this.universityClassesRequest = universityClassesRequest;
    }
}

