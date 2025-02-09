package com.reinertisa.su.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class UniversityClassRequest {

    @NotBlank(message = "This field is required.")
    private String universityClassName;

    @NotNull(message = "This field is required.")
    private Integer courseId;

    @NotBlank(message = "This field is required.")
    private String professor;

    @NotBlank(message = "This field is required.")
    private String description;

    public String getUniversityClassName() {
        return universityClassName;
    }

    public void setUniversityClassName(String universityClassName) {
        this.universityClassName = universityClassName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
