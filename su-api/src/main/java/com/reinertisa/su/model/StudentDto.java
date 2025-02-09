package com.reinertisa.su.model;

import java.util.Set;


public class StudentDto {
    private Long id;

    private String studentName;

    private String studentId;

    private String studentEmail;

    private Set<UniversityClassDto> universityClassesDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<UniversityClassDto> getUniversityClassesDto() {
        return universityClassesDto;
    }

    public void setUniversityClassesDto(Set<UniversityClassDto> universityClassesDto) {
        this.universityClassesDto = universityClassesDto;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", universityClassesDto=" + universityClassesDto +
                '}';
    }
}
